package algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphTraverseDFS<T> {

  Map<T, Vertex> graph = new HashMap<>();

  public void addEdge(T source, T dest) {
    graph.computeIfAbsent(source, Vertex::new);
    graph.computeIfAbsent(dest, Vertex::new);
    graph.get(source).addEdge(graph.get(dest));
  }

  public List<T> traversePath(T start) {
    Vertex vs = graph.get(start);
    if (vs == null) {
      throw new IllegalArgumentException("invalid start : " + start);
    }

    List<T> result = new ArrayList<>();

    Stack<Vertex> stack = new Stack<>();
    stack.push(vs);

    while(!stack.isEmpty()) {
      Vertex poll = stack.pop();
      if (!poll.isVisited) {
        poll.isVisited = true;
        result.add(poll.v);

        for (Edge edge : poll.edges) {
          Vertex dest = edge.dest;
          stack.push(dest);
        }
      }
    }

    return result;
  }

  class Vertex {
    T v;

    boolean isVisited = false;

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
