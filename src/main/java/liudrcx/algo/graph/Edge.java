package liudrcx.algo.graph;
public class Edge {

  private Vertex linked; //指向的顶点
  private int weight;

  public Edge(Vertex linked) {
    this.linked = linked;
  }

  public Edge(Vertex linked, int weight) {
    this.linked = linked;
    this.weight = weight;
  }

  public Vertex getLinked() {
    return linked;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}
