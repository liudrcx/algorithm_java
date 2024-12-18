package algo.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static algo.graph.BellmanFordShortestPath.Vertex.INF;

public class BellmanFordShortestPath<T> implements SingleSourceShortestPath<T> {

  Map<T, Vertex> graph = new LinkedHashMap<>();

  public void addEdge(T source, T target, int weight) {
    if (weight < 0) {
      throw new IllegalArgumentException("Invalid weight: " + weight);
    }

    graph.computeIfAbsent(source, Vertex::new);
    graph.computeIfAbsent(target, Vertex::new);

    graph.get(source).addDest(graph.get(target), weight);
  }

  @Override
  public List<List<T>> findPaths(T source) {
    Vertex sv = graph.get(source);
    if (sv == null) {
      throw new IllegalArgumentException("invalid source: " + source);
    }

    sv.dist = 0;

    for (int i = 0; i < graph.size() - 1; i++) {
      for (Vertex vertex : graph.values()) {
        for (Edge edge : vertex.edgeList) {
          Vertex dest = edge.dest;
          if (vertex.dist != INF && vertex.dist + edge.weight < dest.dist) {
            dest.dist = vertex.dist + edge.weight;
            dest.prev = vertex;
          }
        }
      }
    }

    List<List<T>> result = new ArrayList<>();
    for (Vertex vertex : graph.values()) {
      LinkedList<T> path = new LinkedList<>();
      result.add(path);
      Vertex v = vertex;
      while(v != null) {
        path.addFirst(v.v);
        v = v.prev;
      }
    }

    return result;
  }

  class Vertex {
    T v;

    static final int INF = Integer.MAX_VALUE;

    int dist = INF;

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
