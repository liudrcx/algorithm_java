package algoritm.sorting;

import algorithm.sorting.SelectionSorting;
import algorithm.sorting.ShellSorting;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShellSortingTest {

  @Test
  public void testSort() {
    int[] expected = {1, 2, 3, 4, 5};
    int[] a1 = {5, 4, 3, 2, 1};

    ShellSorting shellSorting = new ShellSorting();

    shellSorting.sort(a1);
    assertThat(a1).containsExactly(expected);

    int[] a2 = {4, 5, 3, 2, 1};
    shellSorting.sort(a2);
    assertThat(a2).containsExactly(expected);

    int[] a4 = {3, 1, 4, 2, 5};
    shellSorting.sort(a4);
    assertThat(a4).containsExactly(expected);

    int[] a3 = {1, 2, 3, 4, 5};
    shellSorting.sort(a3);
    assertThat(a3).containsExactly(expected);
  }
}
