package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static algo.graph.GraphTestUtil.assertContainsPath;

public class GraphPathBFSTest {

  @Test
  public void testBFS() {
    GraphPathBFS<Integer> graphPathBFS = new GraphPathBFS<>();
    graphPathBFS.addEdge(0, 1);
    graphPathBFS.addEdge(0, 3);
    graphPathBFS.addEdge(1, 2);
    graphPathBFS.addEdge(1, 4);
    graphPathBFS.addEdge(2, 5);
    graphPathBFS.addEdge(3, 4);
    graphPathBFS.addEdge(4, 5);
    graphPathBFS.addEdge(4, 6);
    graphPathBFS.addEdge(5, 7);
    graphPathBFS.addEdge(6, 7);

    List<Integer> path = graphPathBFS.findPath(0, 6);
    assertContainsPath(
      List.of(
        List.of(0, 1, 4, 6),
        List.of(0, 3, 4, 6)
      ),
      path
    );


    System.out.println(path);
  }
}
