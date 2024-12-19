package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static algo.graph.GraphTestUtil.assertContainsPath;

public class DijkstraShortestPathTest {

  @Test
  public void testFindPaths() {
    DijkstraShortestPath<String> shortestPath = new DijkstraShortestPath<>();
    shortestPath.addEdge("v1", "v2", 2);
    shortestPath.addEdge("v1", "v3", 1);
    shortestPath.addEdge("v2", "v3", 1);
    shortestPath.addEdge("v3", "v4", 1);

    List<String> path = shortestPath.findPath("v1", "v4");

    assertContainsPath(
      List.of(
        List.of("v1", "v3", "v4")
      ),
      path
    );
  }
}
