package liudrcx.algo.recursion;

public class BubbleSort {

  public static void sort(int[] arr) {
    sort(arr, arr.length - 1);
  }

  private static void sort(int[] arr, int j) {
    if (j == 0) {
      return;
    }

    int x = 0;
    for (int i = 0; i < j; i++) {
      if (arr[i] > arr[i + 1]) {
        int tmp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = tmp;
        x = i;
      }
    }

    sort(arr, x);
  }
}
