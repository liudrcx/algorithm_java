package algo.sorting.mergesorting;

public class MergeSortingUpToBottom<T extends Comparable<T>> extends MergeSorting<T>{

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

    int midIndex = (leftIndex + rightIndex) >>> 1;
    _sort(data, leftIndex, midIndex);
    _sort(data, midIndex + 1, rightIndex);

    _merge(data, leftIndex, midIndex, rightIndex);
  }
}
