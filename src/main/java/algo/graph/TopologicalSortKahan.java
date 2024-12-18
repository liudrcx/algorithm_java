package algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortKahan<T> implements TopologicalSort<T> {

  Map<T, Vertex> graph = new HashMap<>();

  public void addEdge(T source, T dest) {
    graph.computeIfAbsent(source, Vertex::new);
    graph.computeIfAbsent(dest, Vertex::new);
    graph.get(source).addDest(graph.get(dest));
  }

  @Override
  public List<T> resolveTopologicalSort() {
    List<T> result = new ArrayList<>();

    for (Vertex v : graph.values()) {
      for (Edge edge : v.edgeList) {
        edge.dest.inDegree++;
      }
    }

    Queue<Vertex> queue = new LinkedList<>();
    for (Vertex v : graph.values()) {
      if (v.inDegree == 0) {
        queue.offer(v);
      }
    }

    while (!queue.isEmpty()) {
      Vertex v = queue.poll();
      result.add(v.v);

      for(Edge edge : v.edgeList) {
        Vertex dest = edge.dest;
        dest.inDegree--;

        if (dest.inDegree == 0) {
          queue.offer(dest);
        }
      }
    }

    if (graph.size() != result.size()) {
      throw new IllegalStateException("cycle dependecy detected");
    }

    return result;
  }

  class Vertex {

    Vertex(T v) {
      this.v = v;
    }

    T v;

    int inDegree = 0;

    List<Edge> edgeList = new ArrayList<>();

    void addDest(Vertex dest) {
      Edge edge = new Edge(dest);
      edgeList.add(edge);
    }
  }

  class Edge {

    Vertex dest;

    Edge(Vertex dest) {
      this.dest = dest;
    }
  }
}
