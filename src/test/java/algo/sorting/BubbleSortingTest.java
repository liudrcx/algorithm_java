package algo.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortingTest {

  @Test
  public void testSort() {
    Integer[] data = new Integer[] {7, 5, 3, 4, 8, 9, 1};
    BubbleSorting.sort(data);
    assertArrayEquals(new Integer[] {1, 3, 4, 5, 7, 8, 9}, data);
  }

  @Test
  public void testSortByEnhancement() {
    Integer[] data = new Integer[] {7, 5, 3, 4, 8, 9, 1};
    BubbleSorting.sortByEnhancement(data);
    assertArrayEquals(new Integer[] {1, 3, 4, 5, 7, 8, 9}, data);
  }
}
