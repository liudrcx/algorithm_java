package algorithm.binarysearch;

public class BinarySearch {

  /**
   * find index of unique element target in sorted arr, if target does not exist, return -1
   * @param arr
   * @param target
   * @return
   */
  public static int binarySearchBasic(int[] arr, int target) {
    int i = 0, j = arr.length - 1;
    while(i <= j) {
      int mid = (i + j) >>> 1;
      if (target < arr[mid]) {
        j = mid - 1;
      } else if (arr[mid] < target) {
        i = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  /**
   * find left most index of element target in sorted arr, if target does not exist, return -1
   * @param arr
   * @param target
   * @return
   */
  public static int binarySearchLeftMost1(int[] arr, int target) {
    int i = 0, j = arr.length - 1;
    int candidateIndex= -1;

    while(i <= j) {
      int mid = (i + j) >>> 1;
      if (arr[mid] < target) {
        i = mid + 1;
      } else if (target < arr[mid]) {
        j = mid - 1;
      } else {
        candidateIndex = mid;
        j = mid - 1;
      }
    }

    return candidateIndex;
  }

  /**
   * find right most index of element target in sorted arr, if target does not exist, return -1
   * @param arr
   * @param target
   * @return
   */
  public static int binarySearchRightMost1(int[] arr, int target) {
    int i = 0, j = arr.length - 1;
    int candinateIndex = -1;

    while(i <= j) {
      int mid = (i + j) >>> 1;
      if (target < arr[mid]) {
        j = mid - 1;
      } else if (arr[mid] < target) {
        i = mid + 1;
      } else {
        candinateIndex = mid;
        i = mid + 1;
      }
    }

    return candinateIndex;
  }

  /**
   * find index of element of left most greater than or euqals to target in sorted arr
   * @param arr
   * @param target
   * @return
   */
  public static int binarySearchLeftMost2(int[] arr, int target) {
    int i = 0, j = arr.length - 1;

    while(i <= j) {
      int mid = (i + j) >>> 1;
      if (target <= arr[mid]) {
        j = mid - 1;
      } else {
        i = mid + 1;
      }
    }

    return i;
  }

  /**
   * find index of element of right most less than or euqals to target in sorted arr
   * @param arr
   * @param target
   * @return
   */
  public static int binarySearchRightMost2(int[] arr, int target) {
    int i = 0, j = arr.length - 1;

    while(i <= j) {
      int mid = (i + j) >>> 1;

      if (arr[mid] <= target) {
        i = mid + 1;
      } else {
        j = mid - 1;
      }
    }

    return i - 1;
  }

}
