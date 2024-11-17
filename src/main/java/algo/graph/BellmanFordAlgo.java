package algo.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class BellmanFordAlgo {

  LinkedHashMap<String, Vertex> graph = new LinkedHashMap<>();

  public BellmanFordAlgo(String[][] items) {
    for (String[] item : items) {
      graph.computeIfAbsent(item[0], k -> new Vertex(k));
      graph.computeIfAbsent(item[1], k -> new Vertex(k));
    }

    for(String[] item : items) {
      Edge edge = new Edge(graph.get(item[1]));
      edge.weight = Integer.parseInt(item[2]);
      graph.get(item[0]).edges.add(edge);
    }
  }

  public int minPathDistanceOf(String startName, String targetName) {
    Vertex start = vertex(startName);
    Vertex target = vertex(targetName);

    calcMinPath(start);

    return target.distance;
  }

  public List<String> minPathOf(String startName, String targetName) {
    Vertex start = vertex(startName);
    Vertex target = vertex(targetName);

    calcMinPath(start);

    LinkedList<String> result = new LinkedList<>();
    while(target != start) {
      result.addFirst(target.name);
      target = target.prevVertex;
    }
    result.addFirst(start.name);

    return result;
  }

  private Vertex vertex(String name) {
    Vertex vertex = graph.get(name);
    if (vertex == null) {
      throw new IllegalArgumentException("invalid name: " + name);
    }
    return vertex;
  }

  private void calcMinPath(Vertex start) {
    start.distance = 0;

    for (int i = 0; i < graph.size() - 1; i++) {
      for (Vertex source : graph.values()) {
        for(Edge edge : source.edges) {
          Vertex dest = edge.destTo;
          if (source.distance != Integer.MAX_VALUE
            && ((source.distance + edge.weight) < dest.distance)) {
            dest.distance = source.distance + edge.weight;
            dest.prevVertex = source;
          }
        }
      }
    }
  }

  private class Vertex {
    String name;

    int distance = Integer.MAX_VALUE;

    Vertex prevVertex;

    List<Edge> edges = new ArrayList<>();

    public Vertex(String name) {
      this.name = name;
    }
  }

  private class Edge {

    public Edge(Vertex destTo) {
      this.destTo = destTo;
    }

    Vertex destTo;

    int weight = 0;
  }
}
