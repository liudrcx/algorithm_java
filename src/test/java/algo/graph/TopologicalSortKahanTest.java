package algo.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static algo.graph.GraphTestUtil.assertContainsPath;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class TopologicalSortKahanTest {

  /**
   *   1 - 2  - 3 - 7
   *          \   /
   *            4
   */
  @Test
  public void testSort() {
    TopologicalSortKahan<Integer> kahan = new TopologicalSortKahan<>();
    kahan.addEdge(1, 2);
    kahan.addEdge(2, 3);
    kahan.addEdge(2, 4);
    kahan.addEdge(3, 7);
    kahan.addEdge(4, 7);

    List<Integer> result = kahan.resolveTopologicalSort();
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
    TopologicalSortKahan<Integer> kahan = new TopologicalSortKahan<>();
    kahan.addEdge(1, 2);
    kahan.addEdge(2, 3);
    kahan.addEdge(2, 4);
    kahan.addEdge(3, 7);
    kahan.addEdge(3, 2);
    kahan.addEdge(4, 7);

    assertThrowsExactly(IllegalStateException.class, () -> kahan.resolveTopologicalSort());
  }
}
