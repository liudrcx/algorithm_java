package liudrcx.algo.sorting;
public class BubbleSort {

  public void sort1(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      boolean isSwap = false;
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
          isSwap = true;
        }
      }

      if (!isSwap) {
        break;
      }
    }
  }

  public void sort2(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }

    int n = arr.length - 1;
    while(true) {
      int lastSwapIndex = 0;
      for (int i = 0; i < n; i++) {
        if (arr[i] > arr[i + 1]) {
          swap(arr, i, i + 1);
          lastSwapIndex = i;
        }
      }
      n = lastSwapIndex;
      if (n == 0) {
        break;
      }
    }
  }

  private void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }
}
