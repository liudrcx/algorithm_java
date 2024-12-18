package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static algo.graph.GraphTestUtil.assertContainsPath;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class TopologicalSortDFSTest {

  /**
   *   1 - 2  - 3 - 7
   *          \   /
   *            4
   */
  @Test
  public void testSort() {
    TopologicalSortDFS<Integer> dfs = new TopologicalSortDFS<>();
    dfs.addEdge(1, 2);
    dfs.addEdge(2, 3);
    dfs.addEdge(2, 4);
    dfs.addEdge(3, 7);
    dfs.addEdge(4, 7);

    List<Integer> result = dfs.resolveTopologicalSort();
    assertContainsPath(
      List.of(
        List.of(1, 2, 3, 4, 7),
        List.of(1, 2, 4, 3, 7)
      ),
      result
    );
  }

  /**
   *          <-
   *   1 - 2  -> 3 - 7
   *          \   /
   *            4
   */

  @Test
  public void testSortWithCycleDependency() {
    TopologicalSortDFS<Integer> dfs = new TopologicalSortDFS<>();
    dfs.addEdge(1, 2);
    dfs.addEdge(2, 3);
    dfs.addEdge(2, 4);
    dfs.addEdge(3, 7);
    dfs.addEdge(3, 2);
    dfs.addEdge(4, 7);

    assertThrowsExactly(IllegalStateException.class, () -> dfs.resolveTopologicalSort());
  }
}
