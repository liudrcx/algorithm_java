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

  private void checkPath(List<String> result, List<String> expected) {
    assertThat(result.size()).isEqualTo(expected.size());
    for (String s : result) {
      if (expected.stream().noneMatch(e -> e.equals(s))) {
        Assertions.fail("Invalid Path");
      }
    }
  }

}
