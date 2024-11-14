package algo.sorting;

public class SelectionSorting {

  public static <T extends Comparable<T>> void sort(T[] data) {
    if (data == null || data.length <= 1) {
      return;
    }

    for (int i = 0; i < data.length - 1; i++) {
      int minIndex = i;
      for(int j = i + 1; j < data.length; j++) {
        if (data[minIndex].compareTo(data[j]) > 0) {
          minIndex = j;
        }
      }

      if (minIndex != i) {
        T tmp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = tmp;
      }
    }
  }
}
