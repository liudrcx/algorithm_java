package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static algo.graph.GraphTestUtil.assertContainsPath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BellmanFordShortestPathTest {

  @Test
  public void testFindPaths() {
    BellmanFordShortestPath<String> shortestPath = new BellmanFordShortestPath<>();
    shortestPath.addEdge("v1", "v2", 2);
    shortestPath.addEdge("v1", "v3", 1);
    shortestPath.addEdge("v2", "v3", 1);
    shortestPath.addEdge("v3", "v4", 1);

    List<List<String>> paths = shortestPath.findPaths("v1");

    assertEquals(4,paths.size());
    paths.forEach(path -> assertContainsPath(
      List.of(
        List.of("v1"),
        List.of("v1", "v2"),
        List.of("v1", "v3"),
        List.of("v1", "v3", "v4")
      ),
      path
    ));
  }
}
