package algo.sorting.mergesorting;

public abstract class MergeSorting<T extends Comparable<T>> {
  public abstract void sort(T[] data);

  protected void _merge(T[] data, int leftIndex, int midIndex, int rightIndex) {
    int i = leftIndex, j = midIndex + 1, k = 0;
    T[] tmp = (T[]) new Comparable[rightIndex - leftIndex + 1];

    while(i <= midIndex && j <= rightIndex) {
      if (data[i].compareTo(data[j]) <= 0) {
        tmp[k++] = data[i++];
      } else {
        tmp[k++] = data[j++];
      }
    }

    int start = i, end = midIndex;
    if (j <= rightIndex) {
      start = j;
      end = rightIndex;
    }

    while(start <= end) {
      tmp[k++] = data[start++];
    }

    System.arraycopy(tmp, 0, data, leftIndex, rightIndex - leftIndex + 1);

  }
}
