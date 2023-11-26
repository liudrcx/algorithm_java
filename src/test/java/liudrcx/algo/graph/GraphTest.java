package liudrcx.algo.graph;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTest {

  @Test
  public void testDFS() {
    Vertex v1 = new Vertex("v1");
    Vertex v2 = new Vertex("v2");
    Vertex v3 = new Vertex("v3");
    Vertex v4 = new Vertex("v4");
    Vertex v5 = new Vertex("v5");
    Vertex v6 = new Vertex("v6");

    Graph g= new Graph();
    g.addVertices(
        v1.addEdges(new Edge(v3), new Edge(v2), new Edge(v6)),
        v2.addEdges(new Edge(v4)),
        v3.addEdges(new Edge(v4), new Edge(v6)),
        v4.addEdges(new Edge(v5)),
        v5.addEdges(new Edge(v5)),
        v6.addEdges(new Edge(v5))
    );

    List<String> result = g.dfs("v1");
    checkPath(result, List.of("v1", "v2", "v3", "v4", "v5", "v6"));
  }

  @Test
  public void testDfsWithStack() {
    Vertex v1 = new Vertex("v1");
    Vertex v2 = new Vertex("v2");
    Vertex v3 = new Vertex("v3");
    Vertex v4 = new Vertex("v4");
    Vertex v5 = new Vertex("v5");
    Vertex v6 = new Vertex("v6");

    Graph g= new Graph();
    g.addVertices(
        v1.addEdges(new Edge(v3), new Edge(v2), new Edge(v6)),
        v2.addEdges(new Edge(v4)),
        v3.addEdges(new Edge(v4), new Edge(v6)),
        v4.addEdges(new Edge(v5)),
        v5.addEdges(new Edge(v5)),
        v6.addEdges(new Edge(v5))
    );

    List<String> result = g.dfsWithStack("v1");
    checkPath(result, List.of("v1", "v2", "v3", "v4", "v5", "v6"));
  }

  @Test
  public void testBfs() {
    Vertex v1 = new Vertex("v1");
    Vertex v2 = new Vertex("v2");
    Vertex v3 = new Vertex("v3");
    Vertex v4 = new Vertex("v4");
    Vertex v5 = new Vertex("v5");
    Vertex v6 = new Vertex("v6");

    Graph g= new Graph();
    g.addVertices(
        v1.addEdges(new Edge(v3), new Edge(v2), new Edge(v6)),
        v2.addEdges(new Edge(v4)),
        v3.addEdges(new Edge(v4), new Edge(v6)),
        v4.addEdges(new Edge(v5)),
        v5.addEdges(new Edge(v5)),
        v6.addEdges(new Edge(v5))
    );

    List<String> result = g.bfs("v1");
    checkPath(result, List.of("v1", "v2", "v3", "v4", "v5", "v6"));
  }

  @Test
  public void testTopoLogicalSortWithKahn() {
    Vertex v1 = new Vertex("网页基础");
    Vertex v2 = new Vertex("Java基础");
    Vertex v3 = new Vertex("JavaWeb");
    Vertex v4 = new Vertex("Spring框架");
    Vertex v5 = new Vertex("微服务框架");
    Vertex v6 = new Vertex("数据库");
    Vertex v7 = new Vertex("实战项目");

    Graph graph = new Graph();
    graph.addVertices(
        v1.addEdges(new Edge(v3)),
        v2.addEdges(new Edge(v3)),
        v3.addEdges(new Edge(v4)),
        v6.addEdges(new Edge(v4)),
        v4.addEdges(new Edge(v5)),
        v5.addEdges(new Edge(v7)),
        v7
    );

    List<String> result = graph.topoLogicalSortWithKahn();
    assertThat(result.size()).isEqualTo(7);
    assertThat(result).containsExactly("网页基础", "Java基础", "数据库", "JavaWeb", "Spring框架", "微服务框架", "实战项目");
  }

  @Test
  public void testTopoLogicalSortWithDfs() {
    Vertex v1 = new Vertex("网页基础");
    Vertex v2 = new Vertex("Java基础");
    Vertex v3 = new Vertex("JavaWeb");
    Vertex v4 = new Vertex("Spring框架");
    Vertex v5 = new Vertex("微服务框架");
    Vertex v6 = new Vertex("数据库");
    Vertex v7 = new Vertex("实战项目");

    Graph graph = new Graph();
    graph.addVertices(
        v1.addEdges(new Edge(v3)),
        v2.addEdges(new Edge(v3)),
        v3.addEdges(new Edge(v4)),
        v6.addEdges(new Edge(v4)),
        v4.addEdges(new Edge(v5)),
        v5.addEdges(new Edge(v7)),
        v7
    );

    List<String> result = graph.topoLogicWithDfs();
    assertThat(result.size()).isEqualTo(7);
    assertThat(result).contains("网页基础", "Java基础", "数据库", "JavaWeb", "Spring框架", "微服务框架", "实战项目");
  }

  private void checkPath(List<String> result, List<String> expected) {
    assertThat(result.size()).isEqualTo(expected.size());
    for (String s : result) {
      if (expected.stream().noneMatch(e -> e.equals(s))) {
        Assertions.fail("Invalid Path");
      }
    }
  }

}
