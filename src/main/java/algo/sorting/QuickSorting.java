package algo.sorting;

public class QuickSorting {

  public static <T extends Comparable<T>> void sort(T[] data) {
    if (data == null || data.length == 0 || data.length == 1) {
      return;
    }
    sort(data, 0, data.length - 1);
  }

  private static <T extends Comparable<T>> void sort(T[] data, int start, int end) {
    if (start >= end) {
      return;
    }

    int pivotIndex = partition(data, start, end);
    sort(data, start, pivotIndex - 1);
    sort(data, pivotIndex + 1, end);
  }

  private static <T extends Comparable<T>> int partition(T[] data, int start, int end) {
    T pivot = data[end];
    int i = start;
    for (int j = start; j < end; j++) {
      if (data[j].compareTo(pivot) < 0) {
        swap(data, i, j);
        i++;
      }
    }
    swap(data, i, end);
    return i;
  }

  private static <T extends Comparable<T>> void swap(T[] data, int left, int right) {
    T tmp = data[left];
    data[left] = data[right];
    data[right] = tmp;
  }
}
