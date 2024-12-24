package algo.sorting;

public class CountSorting {

  public static void sort(int[] data) {
    if (data == null || data.length == 0 || data.length == 1) {
      return;
    }

    int max = data[0];
    for (int i = 1; i < data.length; i++) {
      if (max < data[i]) {
        max = data[i];
      }
    }

    int[] c = new int[max + 1];
    for (int i = 0; i < c.length; i++) {
      c[i] = 0;
    }

    for (int i = 0; i < data.length; i++) {
      c[data[i]]++;
    }

    for(int i = 1; i < c.length; i++) {
      c[i] = c[i] + c[i - 1];
    }

    int[] r = new int[data.length];
    for (int i = data.length - 1; i >= 0; i--) {
      int index = c[data[i]] - 1;
      r[index] = data[i];
      c[data[i]]--;
    }

    for (int i = 0; i < data.length; i++) {
      data[i] = r[i];
    }
  }
}
