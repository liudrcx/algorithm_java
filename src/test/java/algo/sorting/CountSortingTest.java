package algo.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountSortingTest {

  @Test
  public void testSorting() {
    int[] data = new int[] {7, 5, 3, 4, 8, 9, 1};
    CountSorting.sort(data);
    assertArrayEquals(new int[] {1, 3, 4, 5, 7, 8, 9}, data);
  }
}
