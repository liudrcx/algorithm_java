package algo.binarysearch;

public class BinarySearchAlternativeBasic<T extends Comparable<T>> implements BinarySearchExecutor<T> {

  @Override
  public int search(T[] data, T target) {
    if (data == null || data.length == 0) {
      return -1;
    }

    int i = 0, j = data.length;
    while(i < j) {
      int m = (i + j) >>> 1;
      if (target.compareTo(data[m]) < 0) {
        j = m;
      } else if (target.compareTo(data[m]) > 0) {
        i = m + 1;
      } else {
        return m;
      }
    }
    return -1;
  }
}
