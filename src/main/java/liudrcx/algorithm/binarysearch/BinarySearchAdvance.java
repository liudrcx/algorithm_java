package liudrcx.algorithm.binarysearch;

public class BinarySearchAdvance {

  /**
   *
   * @param arr is an un-unique sorted array
   * @param target
   * @return index of left most of target, return -1 if target not exists
   */
  public int leftMostSearch1(int[] arr, int target) {
    int i= 0, j = arr.length - 1;
    int result = -1;

    while(i <= j) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m - 1;
      } else if (arr[m] < target) {
        i = m + 1;
      } else {
        result = m;
        j = m - 1;
      }
    }

    return result;
  }

  /**
   *
   * @param arr is an un-unique sorted array
   * @param target
   * @return >= target, left most index
   */
  public int leftMostSearch2(int[] arr, int target) {
    int i = 0, j = arr.length - 1;

    while(i <= j) {
      int m = (i + j) >>> 1;
      if (arr[m] < target) {
        i = m + 1;
      } else {
        j = m - 1;
      }
    }

    return i;
  }

  /**
   *
   * @param arr is an un-unique sorted array
   * @param target
   * @return index of right most of target, return -1 if target not exists
   */
  public int rightMostSearch1(int[] arr, int target) {
    int i = 0, j = arr.length - 1;
    int result = -1;
    while(i <= j) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m - 1;
      } else if (arr[m] < target) {
        i = m + 1;
      } else {
        result = m;
        i = m + 1;
      }
    }
    return result;
  }


  /**
   *
   * @param arr is an un-unique sorted array
   * @param target
   * @return <= target, right most index
   */
  public int rightMostSearch2(int[] arr, int target) {
    int i = 0, j = arr.length - 1;

    while(i <= j) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m - 1;
      } else {
        i = m + 1;
      }
    }

    return i - 1;
  }


}
