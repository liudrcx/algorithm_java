package algoritm.binarysearch;

import org.junit.jupiter.api.Test;

import static algorithm.binarysearch.BinarySearch.binarySearchBasic;
import static algorithm.binarysearch.BinarySearch.binarySearchLeftMost1;
import static algorithm.binarysearch.BinarySearch.binarySearchLeftMost2;
import static algorithm.binarysearch.BinarySearch.binarySearchRightMost1;
import static algorithm.binarysearch.BinarySearch.binarySearchRightMost2;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

  @Test
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
  public void testbinarySearchLeftMost1() {
    int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
    assertEquals(0, binarySearchLeftMost1(a, 1));
    assertEquals(1, binarySearchLeftMost1(a, 2));
    assertEquals(2, binarySearchLeftMost1(a, 4));
    assertEquals(5, binarySearchLeftMost1(a, 5));
    assertEquals(6, binarySearchLeftMost1(a, 6));
    assertEquals(7, binarySearchLeftMost1(a, 7));

    assertEquals(-1, binarySearchLeftMost1(a, 0));
    assertEquals(-1, binarySearchLeftMost1(a, 3));
    assertEquals(-1, binarySearchLeftMost1(a, 8));
  }

  @Test
  public void testBinarySearchRightMost1() {
    int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
    assertEquals(0, binarySearchRightMost1(a, 1));
    assertEquals(1, binarySearchRightMost1(a, 2));
    assertEquals(4, binarySearchRightMost1(a, 4));
    assertEquals(5, binarySearchRightMost1(a, 5));
    assertEquals(6, binarySearchRightMost1(a, 6));
    assertEquals(7, binarySearchRightMost1(a, 7));

    assertEquals(-1, binarySearchRightMost1(a, 0));
    assertEquals(-1, binarySearchRightMost1(a, 3));
    assertEquals(-1, binarySearchRightMost1(a, 8));
  }

  @Test
  public void testbinarySearchLeftMost2() {
    int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
    assertEquals(0, binarySearchLeftMost2(a, 1));
    assertEquals(1, binarySearchLeftMost2(a, 2));
    assertEquals(2, binarySearchLeftMost2(a, 4));
    assertEquals(5, binarySearchLeftMost2(a, 5));
    assertEquals(6, binarySearchLeftMost1(a, 6));
    assertEquals(7, binarySearchLeftMost2(a, 7));

    assertEquals(0, binarySearchLeftMost2(a, 0));
    assertEquals(2, binarySearchLeftMost2(a, 3));
    assertEquals(8, binarySearchLeftMost2(a, 8));
  }

  @Test
  public void testbinarySearchRightMost2() {
    int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
    assertEquals(0, binarySearchRightMost2(a, 1));
    assertEquals(1, binarySearchRightMost2(a, 2));
    assertEquals(4, binarySearchRightMost2(a, 4));
    assertEquals(5, binarySearchRightMost2(a, 5));
    assertEquals(6, binarySearchRightMost2(a, 6));
    assertEquals(7, binarySearchRightMost2(a, 7));

    assertEquals(-1, binarySearchRightMost2(a, 0));
    assertEquals(1, binarySearchRightMost2(a, 3));
    assertEquals(7, binarySearchRightMost2(a, 8));
  }
}
