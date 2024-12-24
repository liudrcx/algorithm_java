package algo.sorting;

public class ShellSorting {

  public static <T extends Comparable<T>> void sort(T[] data) {
    if (data == null || data.length <= 1) {
      return;
    }

    for(int gap = data.length / 2; gap >= 1; gap /= 2) {
      for (int i = gap; i < data.length; i++) {
        T value = data[i];
        int j = i - gap;

        for(; j >= 0; j -= gap) {
          if (data[j].compareTo(value) > 0) {
            data[j + gap] = data[j];
          } else {
            break;
          }
        }

        data[j + gap] = value;
      }
    }
  }
}
