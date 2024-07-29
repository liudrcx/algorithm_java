package aliu.algo.sorting;

import aliu.algo.sorting.QuickSort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {

  @Test
  public void testSort() {
    int[] expected = {1, 2, 3, 4, 5};
    int[] a1 = {5, 4, 3, 2, 1};

    QuickSort quickSort = new QuickSort();

    quickSort.sort(a1);
    assertThat(a1).containsExactly(expected);

    int[] a2 = {4, 5, 3, 2, 1};
    quickSort.sort(a2);
    assertThat(a2).containsExactly(expected);

    int[] a4 = {3, 1, 4, 2, 5};
    quickSort.sort(a4);
    assertThat(a4).containsExactly(expected);

    int[] a3 = {1, 2, 3, 4, 5};
    quickSort.sort(a3);
    assertThat(a3).containsExactly(expected);
  }

}
