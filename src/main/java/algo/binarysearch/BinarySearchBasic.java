package algo.binarysearch;

public class BinarySearchBasic<E extends Comparable<E>> implements BinarySearchExecutor<E>{

  @Override
  public int search(E[] data, E target) {
    if (data == null || data.length == 0) {
      return -1;
    }

    int i = 0, j = data.length - 1;
    while(i <= j) {
      int m = (i + j) >>> 1;
      if (target.compareTo(data[m]) < 0) {
        j = m - 1;
      } else if (target.compareTo(data[m]) > 0) {
        i = m + 1;
      } else {
        return m;
      }
    }
    return -1;
  }
}
