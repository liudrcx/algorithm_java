package algo.binarysearch;

/**
 * find right most element which is equal or less than target
 * @param <E>
 */
public class BinarySearchRightMost2<E extends Comparable<E>> implements BinarySearchExecutor<E>{

  @Override
  public int search(E[] data, E target) {
    int i = 0, j = data.length - 1;

    while(i <= j) {
      int mid = (i + j) >>> 1;
      if (target.compareTo(data[mid]) < 0) {
        j = mid - 1;
      } else {
        i = mid + 1;
      }
    }

    return i - 1;
  }
}
