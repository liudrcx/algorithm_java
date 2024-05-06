package liudrcx.algorithm.binarysearch;

public class BinarySearchBasic {

  /**
   *
   * @param arr is an unique sorted array
   * @param target
   * @return index of target, return -1 if target not exists
   */
  public int search(int[] arr, int target) {
    int i = 0, j = arr.length - 1;

    while(i <= j) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m - 1;
      } else if (arr[m] < target) {
        i = m + 1;
      } else {
        return m;
      }
    }
    return -1;
  }
}
