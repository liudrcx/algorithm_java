package algo.sorting;

public class InsertionSorting {

  public static <T extends Comparable<T>> void sort(T[] data) {
    if (data == null || data.length <= 1) {
      return;
    }

    for(int i = 1; i < data.length; i++) {
      T value = data[i];
      int j = i - 1;

      for(; j >= 0; j--) {
        if (data[j].compareTo(value) > 0) {
          data[j + 1] = data[j];
        } else {
          break;
        }
      }

      data[j + 1] = value;
    }
  }
}
