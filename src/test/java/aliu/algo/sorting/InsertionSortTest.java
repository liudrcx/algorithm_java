package aliu.algo.sorting;

import aliu.algo.sorting.InsertionSort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertionSortTest {

  @Test
  public void testSort() {
    int[] expected = {1, 2, 3, 4, 5};
    int[] a1 = {5, 4, 3, 2, 1};

    InsertionSort insertionSort = new InsertionSort();

    insertionSort.sort(a1);
    assertThat(a1).containsExactly(expected);

    int[] a2 = {4, 5, 3, 2, 1};
    insertionSort.sort(a2);
    assertThat(a2).containsExactly(expected);

    int[] a4 = {3, 1, 4, 2, 5};
    insertionSort.sort(a4);
    assertThat(a4).containsExactly(expected);

    int[] a3 = {1, 2, 3, 4, 5};
    insertionSort.sort(a3);
    assertThat(a3).containsExactly(expected);
  }

  @Test
  public void testSortRecursion() {
    int[] expected = {1, 2, 3, 4, 5};
    int[] a1 = {5, 4, 3, 2, 1};

    InsertionSort insertionSort = new InsertionSort();

    insertionSort.sort_recursion(a1);
    assertThat(a1).containsExactly(expected);

    int[] a2 = {4, 5, 3, 2, 1};
    insertionSort.sort_recursion(a2);
    assertThat(a2).containsExactly(expected);

    int[] a4 = {3, 1, 4, 2, 5};
    insertionSort.sort_recursion(a4);
    assertThat(a4).containsExactly(expected);

    int[] a3 = {1, 2, 3, 4, 5};
    insertionSort.sort_recursion(a3);
    assertThat(a3).containsExactly(expected);
  }
}
