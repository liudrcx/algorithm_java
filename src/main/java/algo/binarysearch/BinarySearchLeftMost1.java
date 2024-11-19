package algo.binarysearch;

/**
 * find left most element which is equal to target, return -1 if not found
 * @param <E>
 */
public class BinarySearchLeftMost1<E extends Comparable<E>> implements BinarySearchExecutor<E>{

  @Override
  public int search(E[] data, E target) {
    int i = 0, j = data.length - 1;
    int result = -1;

    while(i <= j) {
      int mid = (i + j) >>> 1;
      if (target.compareTo(data[mid]) < 0) {
        j = mid - 1;
      } else if (target.compareTo(data[mid]) > 0) {
        i = mid + 1;
      } else {
        result = mid;
        j = mid - 1;
      }
    }
    return result;
  }
}
