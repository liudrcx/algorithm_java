package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static algo.graph.GraphTestUtil.assertContainsPath;

public class GraphPathDFSByInterationTest {

  @Test
  public void testDFS() {
    GraphPathDFSByInteration<Integer> graphPathDFSByInteration = new GraphPathDFSByInteration<>();
    graphPathDFSByInteration.addEdge(0, 1);
    graphPathDFSByInteration.addEdge(0, 3);
    graphPathDFSByInteration.addEdge(1, 2);
    graphPathDFSByInteration.addEdge(1, 4);
    graphPathDFSByInteration.addEdge(2, 5);
    graphPathDFSByInteration.addEdge(3, 4);
    graphPathDFSByInteration.addEdge(4, 5);
    graphPathDFSByInteration.addEdge(4, 6);
    graphPathDFSByInteration.addEdge(5, 7);
    graphPathDFSByInteration.addEdge(6, 7);

    List<Integer> path = graphPathDFSByInteration.findPath(0, 6);
    assertContainsPath(
      List.of(
        List.of(0, 1, 4, 6),
        List.of(0, 1, 2, 5, 4, 6),
        List.of(0, 1, 2, 5, 7, 6),
        List.of(0, 3, 4, 6),
        List.of(0, 3, 4, 5, 7, 6)
      ),
      path
    );
  }

}
