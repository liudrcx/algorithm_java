package algo.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import static java.util.Comparator.comparingInt;

public class DijkstraAlgo {

  LinkedHashMap<String, Vertex> graph = new LinkedHashMap<>();

  public DijkstraAlgo(String[][] items) {
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

    calcMinPath(start, target);

    return target.distance;
  }

  public List<String> minPathOf(String startName, String targetName) {
    Vertex start = vertex(startName);
    Vertex target = vertex(targetName);

    calcMinPath(start, target);

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

  private void calcMinPath(Vertex start, Vertex target) {
    start.distance = 0;

    PriorityQueue<Vertex> queue =
      new PriorityQueue<>(comparingInt(v -> v.distance));

    for(Vertex vertex : graph.values()) {
      queue.offer(vertex);
    }

    while(!queue.isEmpty()) {
      Vertex pop = queue.poll();

      if (!pop.isVisited) {
        pop.isVisited = true;

        for (Edge edge : pop.edges) {
          Vertex desTo = edge.destTo;
          if (!desTo.isVisited) {
            int d = edge.weight + pop.distance;
            if (d < desTo.distance) {
              desTo.distance = d;
              desTo.prevVertex = pop;
              queue.offer(desTo);
            }
          }
        }
      }
    }
  }

  private class Vertex {
    String name;

    int distance = Integer.MAX_VALUE;

    boolean isVisited = false;

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
