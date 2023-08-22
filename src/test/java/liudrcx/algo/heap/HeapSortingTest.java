package liudrcx.algo.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeapSortingTest {

  @Test
  public void testSoring() {
    HeapSorting sorting = new HeapSorting();

    int[] arr = new int[] {4, 3, 1, 6, 7, 2};
    sorting.sort(arr);
    Assertions.assertArrayEquals(arr, new int[] {1, 2, 3, 4, 6, 7});
  }
}
