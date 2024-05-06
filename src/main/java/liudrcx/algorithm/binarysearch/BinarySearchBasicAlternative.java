package liudrcx.algorithm.binarysearch;

public class BinarySearchBasicAlternative {

  /**
   *
   * @param arr is an unique sorted array
   * @param target
   * @return index of target, return -1 if target not exists
   */
  public int search(int[] arr, int target) {
    int i = 0, j = arr.length;

    while(i < j) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m;
      } else if (arr[m] < target) {
        i = m + 1;
      } else {
        return m;
      }
    }

    return -1;
  }
}
