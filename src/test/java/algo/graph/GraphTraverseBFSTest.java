package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;


public class GraphTraverseBFSTest {

  /**
   *   1 -  2
   *   |    |
   *   4    3
   */
  @Test
  public void testGraphTraverseBFS() {
    GraphTraverseBFS<Integer> graph = new GraphTraverseBFS<>();
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(1, 4);

    List<Integer> result = graph.traversePath(1);

    GraphTestUtil.assertContainsPath(
      List.of(
        List.of(1, 2, 4, 3),
        List.of(1, 4, 2, 3)
      ),
      result
    );
  }
}
