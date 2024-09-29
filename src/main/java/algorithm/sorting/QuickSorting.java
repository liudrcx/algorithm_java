package algorithm.sorting;

public class QuickSorting {

  public void sort(int[] arr) {
    if (arr == null || arr.length == 0 || arr.length == 1) {
      return;
    }

    sort(arr, 0, arr.length - 1);
  }

  private void sort(int[] arr, int p, int r) {
    if (p >= r) {
      return;
    }

    int q = partition(arr, p, r);

    sort(arr, p, q - 1);
    sort(arr, q + 1, r);
  }

  private int partition(int[] arr, int p, int r) {
    int piviot = arr[r];
    int i = p;
    for (int j = p; j < r; j++) {
      if (arr[j] < piviot) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
      }
    }

    int tmp = arr[i];
    arr[i] = arr[r];
    arr[r] = tmp;

    return i;
  }
}
