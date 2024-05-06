package liudrcx.algorithm.binarysearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static liudrcx.algo.binarysearch.BinarySearch.binarySearchLeftmost1;
import static liudrcx.algo.binarysearch.BinarySearch.binarySearchLeftmost2;
import static liudrcx.algo.binarysearch.BinarySearch.binarySearchRightmost1;
import static liudrcx.algo.binarysearch.BinarySearch.binarySearchRightmost2;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchAdvanceTest {

  @Test
  public void testBinarySearchLeftmost1() {
    BinarySearchAdvance binarySearchAdvance = new BinarySearchAdvance();

    int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
    assertEquals(0, binarySearchAdvance.leftMostSearch1(a, 1));
    assertEquals(1, binarySearchAdvance.leftMostSearch1(a, 2));
    assertEquals(2, binarySearchAdvance.leftMostSearch1(a, 4));
    assertEquals(5, binarySearchAdvance.leftMostSearch1(a, 5));
    assertEquals(6, binarySearchAdvance.leftMostSearch1(a, 6));
    assertEquals(7, binarySearchAdvance.leftMostSearch1(a, 7));

    assertEquals(-1, binarySearchAdvance.leftMostSearch1(a, 0));
    assertEquals(-1, binarySearchAdvance.leftMostSearch1(a, 3));
    assertEquals(-1, binarySearchAdvance.leftMostSearch1(a, 8));
  }

  @Test
  public void testBinarySearchLeftmost2() {
    BinarySearchAdvance binarySearchAdvance = new BinarySearchAdvance();
    int[] a = {1, 2, 4, 4, 4, 7, 8};

    assertEquals(0, binarySearchAdvance.leftMostSearch2(a, 1));
    assertEquals(1, binarySearchAdvance.leftMostSearch2(a, 2));
    assertEquals(2, binarySearchAdvance.leftMostSearch2(a, 4));
    assertEquals(5, binarySearchAdvance.leftMostSearch2(a, 7));
    assertEquals(6, binarySearchAdvance.leftMostSearch2(a, 8));

    assertEquals(0, binarySearchAdvance.leftMostSearch2(a, 0));
    assertEquals(2, binarySearchAdvance.leftMostSearch2(a, 3));
    assertEquals(5, binarySearchAdvance.leftMostSearch2(a, 5));
    assertEquals(7, binarySearchAdvance.leftMostSearch2(a, 9));
  }

  @Test
  public void testBinarySearchRightmost1() {
    BinarySearchAdvance binarySearchAdvance = new BinarySearchAdvance();
    int[] a = {1, 2, 4, 4, 4, 5, 6, 7};

    assertEquals(0, binarySearchAdvance.rightMostSearch1(a, 1));
    assertEquals(1, binarySearchAdvance.rightMostSearch1(a, 2));
    assertEquals(4, binarySearchAdvance.rightMostSearch1(a, 4));
    assertEquals(5, binarySearchAdvance.rightMostSearch1(a, 5));
    assertEquals(6, binarySearchAdvance.rightMostSearch1(a, 6));
    assertEquals(7, binarySearchAdvance.rightMostSearch1(a, 7));

    assertEquals(-1, binarySearchAdvance.rightMostSearch1(a, 0));
    assertEquals(-1, binarySearchAdvance.rightMostSearch1(a, 3));
    assertEquals(-1, binarySearchAdvance.rightMostSearch1(a, 8));
  }

  @Test
  public void testBinarySearchRightmost2() {
    BinarySearchAdvance binarySearchAdvance = new BinarySearchAdvance();
    int[] a = {1, 2, 4, 4, 4, 5, 6, 7};

    assertEquals(0, binarySearchAdvance.rightMostSearch2(a, 1));
    assertEquals(1, binarySearchAdvance.rightMostSearch2(a, 2));
    assertEquals(4, binarySearchAdvance.rightMostSearch2(a, 4));
    assertEquals(5, binarySearchAdvance.rightMostSearch2(a, 5));
    assertEquals(6, binarySearchAdvance.rightMostSearch2(a, 6));
    assertEquals(7, binarySearchAdvance.rightMostSearch2(a, 7));

    assertEquals(0, binarySearchAdvance.rightMostSearch2(a, 0) + 1);
    assertEquals(2, binarySearchAdvance.rightMostSearch2(a, 3) + 1);
    assertEquals(8, binarySearchAdvance.rightMostSearch2(a, 8) + 1);
  }
}
