package algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphPathBFS<T> implements GraphPath<T> {

  Map<T, Vertex> graph = new HashMap<>();

  public void addEdge(T source, T dest) {
    graph.computeIfAbsent(source, Vertex::new);
    graph.computeIfAbsent(dest, Vertex::new);
    graph.get(source).addEdge(graph.get(dest));
  }

  @Override
  public List<T> findPath(T start, T end) {
    Vertex vs = graph.get(start);
    if (vs == null) {
      throw new IllegalArgumentException("invalid start : " + start);
    }

    Vertex ve = graph.get(end);
    if (ve == null) {
      throw new IllegalArgumentException("invalid end : " + end);
    }

    LinkedList<T> result = new LinkedList<>();
    if (vs == ve) {
      result.add(start);
      return result;
    }

    Queue<Vertex> queue = new LinkedList<>();
    queue.offer(vs);

    while (!queue.isEmpty()) {
      Vertex vc = queue.poll();
      if (!vc.isVisited) {
        vc.isVisited = true;

        if (vc == ve) {
          break;
        }

        for (Edge edge : vc.edges) {
          Vertex dest = edge.dest;
          dest.prev = vc;
          queue.offer(dest);
        }
      }
    }

    if (ve == null) {
      return result;
    }

    Vertex v = ve;
    while(v != vs) {
      result.addFirst(v.v);
      v = v.prev;
    }
    result.addFirst(vs.v);
    return result;
  }

  class Vertex {
    T v;

    boolean isVisited = false;

    Vertex prev;

    List<Edge> edges = new ArrayList<>();

    Vertex(T v) {
      this.v = v;
    }

    void addEdge(Vertex dest) {
      Edge edge = new Edge(dest);
      edges.add(edge);
    }
  }

  class Edge {

    Vertex dest;

    Edge(Vertex dest) {
      this.dest = dest;
    }
  }
}
