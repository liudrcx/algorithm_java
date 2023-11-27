package liudrcx.algo.binarysearch;

import org.junit.jupiter.api.Test;

import static liudrcx.algo.binarysearch.BinarySearch.binarySearchRecursion;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchRecursionTest {

  @Test
  public void testSearch() {
    int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
    assertEquals(0, binarySearchRecursion(a, 7));
    assertEquals(1, binarySearchRecursion(a, 13));
    assertEquals(2, binarySearchRecursion(a, 21));
    assertEquals(3, binarySearchRecursion(a, 30));
    assertEquals(4, binarySearchRecursion(a, 38));
    assertEquals(5, binarySearchRecursion(a, 44));
    assertEquals(6, binarySearchRecursion(a, 52));
    assertEquals(7, binarySearchRecursion(a, 53));

    assertEquals(-1, binarySearchRecursion(a, 0));
    assertEquals(-1, binarySearchRecursion(a, 15));
    assertEquals(-1, binarySearchRecursion(a, 60));
  }
}
