package liudrcx.algorithm.binarysearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static liudrcx.algo.binarysearch.BinarySearch.binarySearchBasic;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchBasicTest {

  @Test
  public void search_target_in_arr_should_return_index() {
    int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
    BinarySearchBasicAlternative searchBasic = new BinarySearchBasicAlternative();

    assertEquals(0, searchBasic.search(a, 7));
    assertEquals(1, searchBasic.search(a, 13));
    assertEquals(2, searchBasic.search(a, 21));
    assertEquals(3, searchBasic.search(a, 30));
    assertEquals(4, searchBasic.search(a, 38));
    assertEquals(5, searchBasic.search(a, 44));
    assertEquals(6, searchBasic.search(a, 52));
    assertEquals(7, searchBasic.search(a, 53));


  }

  @Test
  public void search_target_not_in_arr_should_return_negative_one() {
    int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
    BinarySearchBasicAlternative searchBasic = new BinarySearchBasicAlternative();

    assertEquals(-1, searchBasic.search(a, 0));
    assertEquals(-1, searchBasic.search(a, 15));
    assertEquals(-1, searchBasic.search(a, 60));
  }
}
