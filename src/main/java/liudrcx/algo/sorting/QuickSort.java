package liudrcx.algo.sorting;
public class QuickSort {

  public void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private int partition(int[] arr, int p, int r) {
    int pivot = arr[r];
    int i = p;
    for (int j = p; j < r; j++) {
      if (arr[j] < pivot) {
        if (i != j) {
          int t = arr[i];
          arr[i] = arr[j];
          arr[j] = t;
        }
        i++;
      }
    }

    int t = arr[i];
    arr[i] = arr[r];
    arr[r] = t;

    return i;
  }

  private void sort(int[] arr, int p, int r) {
    if (p >= r) {
      return;
    }

    int q = partition(arr, p, r);
    sort(arr, p, q - 1);
    sort(arr, q + 1, r);
  }
}
