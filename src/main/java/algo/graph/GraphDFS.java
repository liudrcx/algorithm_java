package algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphDFS<T> {

  Map<T, Vertex> graph = new HashMap<>();

  public void addEdge(T source, T dest) {
    graph.computeIfAbsent(source, Vertex::new);
    graph.computeIfAbsent(dest, Vertex::new);
    graph.get(source).addEdge(graph.get(dest));
  }

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

    findPath(vs, ve);

    Vertex vc = ve;
    while(vc != vs) {
      result.addFirst(vc.v);
      vc = vc.prev;
    }
    result.addFirst(vs.v);
    return result;
  }

  boolean found = false;

  void findPath(Vertex vs, Vertex ve) {
    if (found == true) {
      return;
    }

    vs.isVisited = true;
    if (vs == ve) {
      found = true;
      return;
    }

    for (Edge edge : vs.edges) {
      Vertex vd = edge.dest;
      if (!vd.isVisited) {
        vd.prev = vs;
        findPath(vd, ve);
      }
    }
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
