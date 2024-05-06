package liudrcx.algorithm.binarysearch;

public class BinarySearchBasicBalance {

  /**
   *
   * @param arr is an unique sorted array
   * @param target
   * @return index of target, return -1 if target not exists
   */
  public int search(int[] arr, int target) {
    int i = 0, j = arr.length;

    while(j - i > 1) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m;
      } else {
        i = m;
      }
    }

    return arr[i] == target ? i : -1;
  }
}
