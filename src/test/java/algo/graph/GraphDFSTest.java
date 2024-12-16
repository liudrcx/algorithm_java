package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static algo.graph.GraphTestUtil.assertContainsPath;
import static java.util.List.*;

public class GraphDFSTest {

  @Test
  public void testDFS() {
    GraphDFS<Integer> graphDFS = new GraphDFS<>();
    graphDFS.addEdge(0, 1);
    graphDFS.addEdge(0, 3);
    graphDFS.addEdge(1, 2);
    graphDFS.addEdge(1, 4);
    graphDFS.addEdge(2, 5);
    graphDFS.addEdge(3, 4);
    graphDFS.addEdge(4, 5);
    graphDFS.addEdge(4, 6);
    graphDFS.addEdge(5, 7);
    graphDFS.addEdge(6, 7);

    List<Integer> path = graphDFS.findPath(0, 6);
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
