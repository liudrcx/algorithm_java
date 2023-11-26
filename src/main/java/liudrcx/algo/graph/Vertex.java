package liudrcx.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

  private String name;

  private List<Edge> edges = new ArrayList<>();

  private int status; // 状态 0-未访问 1-访问中 2-访问过

  private int inDegree; //入度

  public Vertex(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Vertex addEdges(Edge... edges) {
    this.edges.addAll(List.of(edges));
    return this;
  }

  public List<Edge> getEdges() {
    return edges;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public void decrIndegree() {
    this.inDegree--;
  }

  public void incrIndegree() {
    this.inDegree++;
  }

  public int getInDegree() {
    return inDegree;
  }
}
