package liudrcx.algo.recursion;

public class InsertionSort {

  public static void sort(int[] arr) {
    sort(arr, 1);
  }

  private static void sort(int[] arr, int low) {
    if (low == arr.length) {
      return;
    }

    int t = arr[low];
    int i = low - 1;
    while(i >= 0 && arr[i] > t) {
      arr[i + 1] = arr[i];
      i--;
    }

    arr[i + 1] = t;

    sort(arr, low + 1);
  }

}
