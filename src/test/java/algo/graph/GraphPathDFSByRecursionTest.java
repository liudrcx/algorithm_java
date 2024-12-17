package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static algo.graph.GraphTestUtil.assertContainsPath;

public class GraphPathDFSByRecursionTest {

  @Test
  public void testDFS() {
    GraphPathDFSByRecursion<Integer> graphPathDFSByRecursion = new GraphPathDFSByRecursion<>();
    graphPathDFSByRecursion.addEdge(0, 1);
    graphPathDFSByRecursion.addEdge(0, 3);
    graphPathDFSByRecursion.addEdge(1, 2);
    graphPathDFSByRecursion.addEdge(1, 4);
    graphPathDFSByRecursion.addEdge(2, 5);
    graphPathDFSByRecursion.addEdge(3, 4);
    graphPathDFSByRecursion.addEdge(4, 5);
    graphPathDFSByRecursion.addEdge(4, 6);
    graphPathDFSByRecursion.addEdge(5, 7);
    graphPathDFSByRecursion.addEdge(6, 7);

    List<Integer> path = graphPathDFSByRecursion.findPath(0, 6);
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
