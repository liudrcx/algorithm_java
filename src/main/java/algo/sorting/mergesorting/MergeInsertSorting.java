package algo.sorting.mergesorting;

public class MergeInsertSorting<T extends Comparable<T>> extends MergeSorting<T>{


  @Override
  public void sort(T[] data) {
    if (data == null || data.length <= 1) {
      return;
    }

    _sort(data, 0, data.length - 1);
  }

  private void _sort(T[] data, int leftIndex, int rightIndex) {
    if (leftIndex >= rightIndex) {
      return;
    }

    if (rightIndex - leftIndex <= 32) {
      _insertSorting(data, leftIndex, rightIndex);
    }

    int midIndex = (leftIndex + rightIndex) >>> 1;
    _sort(data, leftIndex, midIndex);
    _sort(data, midIndex + 1, rightIndex);

    _merge(data, leftIndex, midIndex, rightIndex);
  }

  private void _insertSorting(T[] data, int leftIndex, int rightIndex) {
    for(int i = leftIndex + 1; i <= rightIndex; i++) {
      T value = data[i];
      int j = i - 1;
      for (; j >= leftIndex; j--) {
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
