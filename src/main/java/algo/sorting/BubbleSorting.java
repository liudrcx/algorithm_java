package algo.sorting;

public class BubbleSorting {

  public static <T extends Comparable<T>> void sort(T[] data) {
    if (data == null || data.length <= 1) {
      return;
    }

    for(int i = 0; i < data.length; i++) {
      for (int j = 0; j < data.length - i - 1; j++) {
        if (data[j].compareTo(data[j + 1]) > 0) {
          T tmp = data[j];
          data[j] = data[j + 1];
          data[j + 1] = tmp;
        }
      }
    }
  }

  public static <T extends Comparable<T>> void sortByEnhancement(T[] data) {
    if (data == null || data.length <= 1) {
      return;
    }

    int rightLimitIndex = data.length - 1;

    do {
      int swapIndex = 0;
      for (int i = 0; i < rightLimitIndex; i++) {
        if (data[i].compareTo(data[i + 1]) > 0) {
          T tmp = data[i];
          data[i] = data[i + 1];
          data[i + 1] = tmp;
          swapIndex = i;
        }
      }
      rightLimitIndex = swapIndex;

    } while (rightLimitIndex != 0);
  }
}
