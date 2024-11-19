package algo.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchLeftMost2Test {

  @Test
  public void testSearch() {
    BinarySearchLeftMost2<Integer> search = new BinarySearchLeftMost2<>();

    Integer[] a = {7, 13, 21, 21, 21, 30, 38, 44, 52, 52, 53};
    assertEquals(0, search.search(a, 7));
    assertEquals(1, search.search(a, 13));
    assertEquals(2, search.search(a, 21));
    assertEquals(5, search.search(a, 30));
    assertEquals(6, search.search(a, 38));
    assertEquals(7, search.search(a, 44));
    assertEquals(8, search.search(a, 52));
    assertEquals(10, search.search(a, 53));

    assertEquals(0, search.search(a, 0));
    assertEquals(2, search.search(a, 15));
    assertEquals(11, search.search(a, 60));
  }
}
