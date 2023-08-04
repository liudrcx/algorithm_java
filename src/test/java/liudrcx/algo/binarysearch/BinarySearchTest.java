package liudrcx.algo.binarysearch;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static liudrcx.algo.binarysearch.BinarySearch.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

  @Test
  @DisplayName("testing binarySearchBasic")
  public void testBinarySearchBasic() {
    int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
    assertEquals(0, binarySearchBasic(a, 7));
    assertEquals(1, binarySearchBasic(a, 13));
    assertEquals(2, binarySearchBasic(a, 21));
    assertEquals(3, binarySearchBasic(a, 30));
    assertEquals(4, binarySearchBasic(a, 38));
    assertEquals(5, binarySearchBasic(a, 44));
    assertEquals(6, binarySearchBasic(a, 52));
    assertEquals(7, binarySearchBasic(a, 53));

    assertEquals(-1, binarySearchBasic(a, 0));
    assertEquals(-1, binarySearchBasic(a, 15));
    assertEquals(-1, binarySearchBasic(a, 60));
  }

  @Test
  @DisplayName("testing binarySearchAlternative ")
  public void testBinarySearchAlternative() {
    int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
    assertEquals(0, binarySearchAlternative(a, 7));
    assertEquals(1, binarySearchAlternative(a, 13));
    assertEquals(2, binarySearchAlternative(a, 21));
    assertEquals(3, binarySearchAlternative(a, 30));
    assertEquals(4, binarySearchAlternative(a, 38));
    assertEquals(5, binarySearchAlternative(a, 44));
    assertEquals(6, binarySearchAlternative(a, 52));
    assertEquals(7, binarySearchAlternative(a, 53));

    assertEquals(-1, binarySearchAlternative(a, 0));
    assertEquals(-1, binarySearchAlternative(a, 15));
    assertEquals(-1, binarySearchAlternative(a, 60));
  }

  @Test
  @DisplayName("testing binarySearchBalance")
  public void testBinarySearchBalance() {
    int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
    assertEquals(0, binarySearchBalance(a, 7));
    assertEquals(1, binarySearchBalance(a, 13));
    assertEquals(2, binarySearchBalance(a, 21));
    assertEquals(3, binarySearchBalance(a, 30));
    assertEquals(4, binarySearchBalance(a, 38));
    assertEquals(5, binarySearchBalance(a, 44));
    assertEquals(6, binarySearchBalance(a, 52));
    assertEquals(7, binarySearchBalance(a, 53));

    assertEquals(-1, binarySearchBalance(a, 0));
    assertEquals(-1, binarySearchBalance(a, 15));
    assertEquals(-1, binarySearchBalance(a, 60));
  }

  @Test
  @DisplayName("testing binarySearchLeftmost return -1")
  public void testBinarySearchLeftmost1() {
    int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
    assertEquals(0, binarySearchLeftmost1(a, 1));
    assertEquals(1, binarySearchLeftmost1(a, 2));
    assertEquals(2, binarySearchLeftmost1(a, 4));
    assertEquals(5, binarySearchLeftmost1(a, 5));
    assertEquals(6, binarySearchLeftmost1(a, 6));
    assertEquals(7, binarySearchLeftmost1(a, 7));

    assertEquals(-1, binarySearchLeftmost1(a, 0));
    assertEquals(-1, binarySearchLeftmost1(a, 3));
    assertEquals(-1, binarySearchLeftmost1(a, 8));
  }

  @Test
  @DisplayName("testing binarySearchRightmost return -1")
  public void testBinarySearchRightmost1() {
    int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
    assertEquals(0, binarySearchRightmost1(a, 1));
    assertEquals(1, binarySearchRightmost1(a, 2));
    assertEquals(4, binarySearchRightmost1(a, 4));
    assertEquals(5, binarySearchRightmost1(a, 5));
    assertEquals(6, binarySearchRightmost1(a, 6));
    assertEquals(7, binarySearchRightmost1(a, 7));

    assertEquals(-1, binarySearchRightmost1(a, 0));
    assertEquals(-1, binarySearchRightmost1(a, 3));
    assertEquals(-1, binarySearchRightmost1(a, 8));
  }

  @Test
  @DisplayName("testing binarySearchLeftmost return i")
  public void testBinarySearchLeftmost2() {
    int[] a = {1, 2, 4, 4, 4, 7, 8};
    assertEquals(0, binarySearchLeftmost2(a, 1));
    assertEquals(1, binarySearchLeftmost2(a, 2));
    assertEquals(2, binarySearchLeftmost2(a, 4));
    assertEquals(5, binarySearchLeftmost2(a, 7));
    assertEquals(6, binarySearchLeftmost2(a, 8));

    assertEquals(0, binarySearchLeftmost2(a, 0));
    assertEquals(2, binarySearchLeftmost2(a, 3));
    assertEquals(5, binarySearchLeftmost2(a, 5));
    assertEquals(7, binarySearchLeftmost2(a, 9));
  }

  @Test
  @DisplayName("testing binarySearchRightmost return i-1")
  public void test9() {
    int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
    assertEquals(0, binarySearchRightmost2(a, 1));
    assertEquals(1, binarySearchRightmost2(a, 2));
    assertEquals(4, binarySearchRightmost2(a, 4));
    assertEquals(5, binarySearchRightmost2(a, 5));
    assertEquals(6, binarySearchRightmost2(a, 6));
    assertEquals(7, binarySearchRightmost2(a, 7));

    assertEquals(0, binarySearchRightmost2(a, 0) + 1);
    assertEquals(2, binarySearchRightmost2(a, 3) + 1);
    assertEquals(8, binarySearchRightmost2(a, 8) + 1);
  }
}
