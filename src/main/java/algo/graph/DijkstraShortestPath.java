package algo.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Comparator.comparingInt;

public class DijkstraShortestPath<T> implements GraphPath<T> {

  Map<T, Vertex> graph = new HashMap<>();

  public void addEdge(T source, T target, int weight) {
    if (weight < 0) {
      throw new IllegalArgumentException("Invalid weight: " + weight);
    }

    graph.computeIfAbsent(source, Vertex::new);
    graph.computeIfAbsent(target, Vertex::new);

    graph.get(source).addDest(graph.get(target), weight);
  }

  @Override
  public List<T> findPath(T start, T end) {
    Vertex vs = graph.get(start);
    if (vs == null) {
      throw new IllegalArgumentException("invalid start: " + start);
    }

    Vertex ve = graph.get(end);
    if (ve == null) {
      throw new IllegalArgumentException("invalid end: " + end);
    }

    vs.dist = 0;

    PriorityQueue<Vertex> queue = new PriorityQueue<>(comparingInt(v -> v.dist));
    for (Vertex vertex : graph.values()) {
      queue.offer(vertex);
    }

    while(!queue.isEmpty()) {
      Vertex vertex = queue.poll();
      if (!vertex.isVisited) {
        vertex.isVisited = true;

        for (Edge edge : vertex.edgeList) {
          Vertex dest = edge.dest;
          if (vertex.dist + edge.weight < dest.dist) {
            dest.dist = vertex.dist + edge.weight;
            dest.prev = vertex;
            queue.offer(dest);
          }
        }
      }
    }

    LinkedList<T> path = new LinkedList<>();
    Vertex v = ve;
    while(v != vs) {
      path.addFirst(v.v);
      v = v.prev;
    }
    path.addFirst(vs.v);

    return path;
  }

  class Vertex {
    T v;

    static final int INF = Integer.MAX_VALUE;

    int dist = INF;

    boolean isVisited = false;

    List<Edge> edgeList = new ArrayList<>();

    Vertex prev;

    Vertex(T v) {
      this.v = v;
    }

    void addDest(Vertex dest, int weight) {
      Edge edge = new Edge(dest, weight);
      edgeList.add(edge);
    }
  }

  class Edge {

    Vertex dest;

    int weight = 0;

    Edge(Vertex dest, int weight) {
      this.dest = dest;
      this.weight = weight;
    }
  }
}
