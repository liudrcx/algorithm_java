package algo.recursion;
public class KthSmallest {

  public static int kthSmallest(int[] arr, int k) {
    if (arr == null || arr.length < k) {
      return -1;
    }

    int p = partition(arr, 0, arr.length - 1);
    while(p + 1 != k) {
      if (p + 1 < k) {
        p = partition(arr, p + 1, arr.length -1);
      } else {
        p = partition(arr, 0, p - 1);
      }
    }
    return arr[p];
  }

  private static int partition(int[] arr, int p, int r) {
    int pivot = arr[r];
    int i = p;
    for (int j = p; j < r; j++) {
      if (arr[j] <= pivot) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, r);
    return i;
  }

  private static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }

    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }
}
