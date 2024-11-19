package algo.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchRightMost1Test {

  @Test
  public void testSearch() {
    BinarySearchRightMost1<Integer> search = new BinarySearchRightMost1<>();

    Integer[] a = {7, 13, 21, 21, 21, 30, 38, 44, 52, 52, 53};
    assertEquals(0, search.search(a, 7));
    assertEquals(1, search.search(a, 13));
    assertEquals(4, search.search(a, 21));
    assertEquals(5, search.search(a, 30));
    assertEquals(6, search.search(a, 38));
    assertEquals(7, search.search(a, 44));
    assertEquals(9, search.search(a, 52));
    assertEquals(10, search.search(a, 53));

    assertEquals(-1, search.search(a, 0));
    assertEquals(-1, search.search(a, 15));
    assertEquals(-1, search.search(a, 60));
  }
}
