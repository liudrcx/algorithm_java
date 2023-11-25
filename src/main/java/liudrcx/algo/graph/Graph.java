package liudrcx.algo.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
  private List<Vertex> vertices = new ArrayList<>();

  public void addVertices(Vertex... vertices) {
    this.vertices.addAll(List.of(vertices));
  }

  public List<String> dfsWithStack(String name) {
    List<String> result = new ArrayList<>();
    Vertex v = find(name);

    Stack<Vertex> stack = new Stack<>();
    stack.push(v);

    while(!stack.isEmpty()) {
      Vertex vx = stack.pop();
      if (vx.getStatus() == 0) {
        vx.setStatus(2);
        result.add(vx.getName());

        for (Edge edge : vx.getEdges()) {
          stack.push(edge.getLinked());
        }
      }
    }

    return result;
  }

  public List<String> dfs(String name) {
    List<String> result = new ArrayList<>();
    Vertex v = find(name);
    if (v == null) {
      throw new IllegalArgumentException(String.format("Invalid name: %s", name));
    }
    dfs(v, result);
    return result;
  }

  private Vertex find(String name) {
    for (Vertex vertex : vertices) {
      if (vertex.getName().equals(name)) {
        return vertex;
      }
    }

    return null;
  }

  private void dfs(Vertex v, List<String> result) {
    if (v.getStatus() == 2) {
      return;
    }

    v.setStatus(2);
    result.add(v.getName());

    for (Edge edge : v.getEdges()) {
      dfs(edge.getLinked(), result);
    }
  }

  public List<String> bfs(String name) {
    List<String> result = new ArrayList<>();

    Vertex v = find(name);
    if (v == null) {
      throw new IllegalArgumentException(String.format("Invalid name: %s", name));
    }

    Queue<Vertex> queue = new LinkedList<>();
    queue.add(v);

    while(!queue.isEmpty()) {
      Vertex vx = queue.poll();
      if (vx.getStatus() == 0) {
        vx.setStatus(2);
        result.add(vx.getName());

        for (Edge edge : vx.getEdges()) {
          queue.offer(edge.getLinked());
        }
      }
    }

    return result;
  }
}
