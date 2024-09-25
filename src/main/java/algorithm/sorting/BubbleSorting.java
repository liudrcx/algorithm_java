package algorithm.sorting;

public class BubbleSorting {

  /**
   * sorting without perf enhancement
   * @param arr
   */
  public void sort1(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }

    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = tmp;
        }
      }
    }
  }

  /**
   * sorting with perf enhancement
   * @param arr
   */
  public void sort2(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }

    int n = arr.length - 1;
    while(true) {
      int lastSwapIndex = 0;
      for (int i = 0; i < n; i++) {
        if (arr[i] > arr[i + 1]) {
          int tmp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tmp;
          lastSwapIndex = i;
        }
      }
      n = lastSwapIndex;

      if (n == 0) {
        break;
      }
    }

  }
}
