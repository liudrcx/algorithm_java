package algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologicalSortDFS<T> implements TopologicalSort<T> {

  Map<T, Vertex> graph = new HashMap<>();

  public void addEdge(T source, T dest) {
    graph.computeIfAbsent(source, Vertex::new);
    graph.computeIfAbsent(dest, Vertex::new);
    graph.get(source).addDest(graph.get(dest));
  }

  @Override
  public List<T> resolveTopologicalSort() {
    List<T> result = new ArrayList<>();
    Stack<Vertex> stack = new Stack<>();

    for (Vertex vertex : graph.values()) {
      resolve(vertex, stack);
    }

    while (!stack.isEmpty()) {
      result.add(stack.pop().v);
    }

    return result;
  }

  void resolve(Vertex vertex, Stack<Vertex> stack) {
    if (vertex.status == 2) {
      return;
    }

    if (vertex.status == 1) {
      throw new IllegalStateException("cycle dependency detected");
    }

    vertex.status = 1;

    for (Edge edge : vertex.edgeList) {
      resolve(edge.dest, stack);
    }

    stack.push(vertex);
    vertex.status = 2;
  }

  class Vertex {
    T v;

    /**
     * 0: not vistied
     * 1: visiting
     * 2: visited
     */
    int status = 0;

    List<Edge> edgeList = new ArrayList<>();

    Vertex(T v) {
      this.v = v;
    }

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
