package liudrcx.algo.recursion;

public class BinarySearchRecursion {

  public static int search(int[] arr, int target) {
    return search(arr, target, 0, arr.length - 1);
  }

  public static int search(int[] arr, int target, int low, int high) {
    if (low > high) {
      return -1;
    }

    int mid = (low + high) >>> 1;
    if (target < arr[mid]) {
      return search(arr, target, low, mid - 1);
    } else if (arr[mid] < target) {
      return search(arr, target, mid + 1, high);
    } else {
      return mid;
    }
  }
}
