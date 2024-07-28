package aliu.algo.sorting;
public class InsertionSort {

  public void sort(int[] arr) {
    if (arr == null || arr.length == 0 || arr.length == 1) {
      return;
    }

    for (int i = 1; i < arr.length; i++) {
      int value = arr[i];
      int j = i - 1;
      for (; j >= 0; j--) {
        if (arr[j] > value) {
          arr[j + 1] = arr[j];
        } else {
          break;
        }
      }
      arr[j + 1] = value;
    }
  }

  public void sort_recursion(int[] arr) {
    sort_recursion(arr, 1);
  }

  private void sort_recursion(int[] arr, int low) {
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
    sort_recursion(arr, low + 1);
  }
}
