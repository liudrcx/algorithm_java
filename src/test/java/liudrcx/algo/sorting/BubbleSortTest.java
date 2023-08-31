package liudrcx.algo.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BubbleSortTest {

  @Test
  public void testSort1() {
    int[] expected = {1, 2, 3, 4, 5};
    int[] a1 = {5, 4, 3, 2, 1};

    BubbleSort bubbleSort = new BubbleSort();

    bubbleSort.sort1(a1);
    assertThat(a1).containsExactly(expected);

    int[] a2 = {4, 5, 3, 2, 1};
    bubbleSort.sort1(a2);
    assertThat(a2).containsExactly(expected);

    int[] a4 = {3, 1, 4, 2, 5};
    bubbleSort.sort1(a4);
    assertThat(a4).containsExactly(expected);

    int[] a3 = {1, 2, 3, 4, 5};
    bubbleSort.sort1(a3);
    assertThat(a3).containsExactly(expected);
  }

  @Test
  public void testSort2() {
    int[] expected = {1, 2, 3, 4, 5};
    int[] a1 = {5, 4, 3, 2, 1};

    BubbleSort bubbleSort = new BubbleSort();

    bubbleSort.sort2(a1);
    assertThat(a1).containsExactly(expected);

    int[] a2 = {4, 5, 3, 2, 1};
    bubbleSort.sort2(a2);
    assertThat(a2).containsExactly(expected);

    int[] a4 = {3, 1, 4, 2, 5};
    bubbleSort.sort2(a4);
    assertThat(a4).containsExactly(expected);

    int[] a3 = {1, 2, 3, 4, 5};
    bubbleSort.sort2(a3);
    assertThat(a3).containsExactly(expected);
  }
}
