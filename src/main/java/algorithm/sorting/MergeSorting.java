package algorithm.sorting;

public class MergeSorting {

  public void sort(int[] arr) {
    if (arr == null || arr.length ==0 || arr.length == 1) {
      return;
    }

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

    int start = i, end = q;
    if (j <= r) {
      start = j;
      end = r;
    }
    for (i = start; i <= end; i++) {
      tmp[k++] = arr[i];
    }

    for(i = 0; i < r - p + 1; i++) {
      arr[p + i] = tmp[i];
    }
  }


}
