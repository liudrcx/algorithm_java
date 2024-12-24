package algo.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortingTest {
 @Test
  public void testSort() {
    Integer[] data = new Integer[] {7, 5, 3, 4, 8, 9, 1};
    QuickSorting.sort(data);
    assertArrayEquals(new Integer[] {1, 3, 4, 5, 7, 8, 9}, data);
  }

}
