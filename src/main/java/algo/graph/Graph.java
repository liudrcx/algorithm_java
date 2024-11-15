package algo.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

  LinkedHashMap<String, Vertex> vertexMap = new LinkedHashMap<>();

  public Graph(String[][] items) {
    for (String[] item : items) {
      vertexMap.computeIfAbsent(item[0], k -> new Vertex(k));
      vertexMap.computeIfAbsent(item[1], k -> new Vertex(k));
    }

    for(String[] item : items) {
      Edge edge = new Edge();
      edge.destTo = vertexMap.get(item[1]);
      vertexMap.get(item[0]).edges.add(edge);
    }
  }

  public List<String> dfsPathByIteration(String start) {
    Vertex vertex = vertexMap.get(start);
    if (start == null) {
      throw new IllegalArgumentException("invalid start node: " + start);
    }

    List<String> result = new ArrayList<>();
    Stack<Vertex> stack = new Stack<>();
    stack.push(vertex);

    while(!stack.isEmpty()) {
      Vertex pop = stack.pop();
      if (pop.status == 0) {
        result.add(pop.name);
        pop.status = 2;

        for(Edge edge : pop.edges) {
          stack.push(edge.destTo);
        }
      }
    }

    return result;
  }

  public List<String> dfsPath(String start) {
    Vertex vertex = vertexMap.get(start);
    if (start == null) {
      throw new IllegalArgumentException("invalid start node: " + start);
    }
    return _dfsPath(vertex);
  }

  private List<String> _dfsPath(Vertex vertex) {
    List<String> result = new ArrayList<>();

    if (vertex.status == 2) {
      return result;
    }

    result.add(vertex.name);
    vertex.status = 2;

    for (Edge edge : vertex.edges) {
      result.addAll(_dfsPath(edge.destTo));
    }

    return result;
  }

  public List<String> bfs(String start) {
    Vertex vertex = vertexMap.get(start);
    if (start == null) {
      throw new IllegalArgumentException("invalid start node: " + start);
    }

    List<String> result = new ArrayList<>();
    Queue<Vertex> queue = new LinkedList<>();
    queue.offer(vertex);

    while(!queue.isEmpty()) {
      Vertex v = queue.poll();
      if (v.status == 0) {
        v.status = 2;
        result.add(v.name);

        for(Edge edge : v.edges) {
          queue.offer(edge.destTo);
        }
      }
    }

    return result;
  }

  public List<String> topologicalSortByKahn() {
    List<String> result = new ArrayList<>();

    for(Vertex vertex : vertexMap.values()) {
      for(Edge edge : vertex.edges) {
        edge.destTo.inDegree++;
      }
    }

    Queue<Vertex> queue = new LinkedList<>();
    for(Vertex vertex : vertexMap.values()) {
      if (vertex.inDegree == 0) {
        queue.offer(vertex);
      }
    }

    while(!queue.isEmpty()) {
      Vertex pop = queue.poll();
      result.add(pop.name);

      for (Edge edge : pop.edges) {
        Vertex destTo = edge.destTo;
        destTo.inDegree--;
        if (destTo.inDegree == 0) {
          queue.offer(destTo);
        }
      }
    }

    if (result.size() != vertexMap.size()) {
      throw new IllegalStateException("cycle dependency detected");
    }

    return result;
  }

  public List<String> topologicalSortByDfs() {
    Stack<String> stack = new Stack<>();
    for(Vertex vertex : vertexMap.values()) {
      _topologicalSortByDfs(vertex, stack);
    }

    List<String> result = new ArrayList<>();
    while(!stack.isEmpty()) {
      result.add(stack.pop());
    }
    return result;
  }

  private void _topologicalSortByDfs(Vertex vertex, Stack<String> stack) {
    if (vertex.status == 2) {
      return;
    }

    if (vertex.status == 1) {
      throw new IllegalStateException("cycle dependency detected");
    }

    vertex.status = 1;

    for (Edge edge : vertex.edges) {
      _topologicalSortByDfs(edge.destTo, stack);
    }

    vertex.status = 2;
    stack.push(vertex.name);
  }

  class Vertex {
    String name;

    /**
     * 0: not been visited
     * 1: visiting
     * 2: had been visited
     */
    int status = 0;

    int inDegree = 0;

    List<Edge> edges = new ArrayList<>();

    public Vertex(String name) {
      this.name = name;
    }
  }

  class Edge {

    Vertex destTo;
  }


}
