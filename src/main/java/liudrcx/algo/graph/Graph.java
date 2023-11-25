package liudrcx.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  private List<Vertex> vertices = new ArrayList<>();

  public void addVertices(Vertex... vertices) {
    this.vertices.addAll(List.of(vertices));
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
}
