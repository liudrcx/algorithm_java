package algorithm.sorting;

public class CountSorting {

  public void sort(int[] arr) {
    if (arr == null || arr.length == 0 || arr.length == 1) {
      return;
    }

    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    int[] c = new int[max + 1];
    for (int i = 0; i < c.length; i++) {
      c[i] = 0;
    }

    for (int i = 0; i < arr.length; i++) {
      c[arr[i]]++;
    }

    for (int i = 1; i < c.length; i++) {
      c[i] = c[i - 1] + c[i];
    }

    int[] r = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      int index = c[arr[i]] - 1;
      r[index] = arr[i];
      c[arr[i]]--;
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = r[i];
    }
  }
}
