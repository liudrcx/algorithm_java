package liudrcx.algo.sorting;
public class MergeSort {

  public void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private void sort(int[] arr, int p, int r) {
    if (p >= r) {
      return;
    }

    int q = (p + r) >>> 1;
    sort(arr, p, q);
    sort(arr, q + 1, r);

    merge(arr, p, q, r);
  }

  private void merge(int[] arr, int p, int q, int r) {
    int i = p, j = q + 1;
    int[] tmp = new int[r - p + 1];
    int k = 0;

    while(i <= q && j <= r) {
      if (arr[i] <= arr[j]) {
        tmp[k++] = arr[i++];
      } else {
        tmp[k++] = arr[j++];
      }
    }

    int start = i;
    int end = q;
    if (j <= r) {
      start = j;
      end = r;
    }

    while (start <= end) {
      tmp[k++] = arr[start++];
    }

    for(i = 0; i < r - p + 1; i++) {
      arr[p + i] = tmp[i];
    }
  }
}
