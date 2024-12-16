package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

public class GraphBFSTest {

  @Test
  public void testBFS() {
    GraphBFS<Integer> graphBFS = new GraphBFS<>();
    graphBFS.addEdge(0, 1);
    graphBFS.addEdge(0, 3);
    graphBFS.addEdge(1, 2);
    graphBFS.addEdge(1, 4);
    graphBFS.addEdge(2, 5);
    graphBFS.addEdge(3, 4);
    graphBFS.addEdge(4, 5);
    graphBFS.addEdge(4, 6);
    graphBFS.addEdge(5, 7);
    graphBFS.addEdge(6, 7);

    List<Integer> path = graphBFS.findPath(0, 6);
    GraphTestUtil.assertContainsPath(
      List.of(
        List.of(0, 1, 4, 6),
        List.of(0, 3, 4, 6)
      ),
      path
    );
  }
}
