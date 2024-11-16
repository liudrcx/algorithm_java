package algo.binarysearch;

public interface BinarySearchExecutor<T extends Comparable<T>> {

  /**
   *
   * @param data is a sorted array
   * @param target
   * @return
   */
  int search(T[] data, T target);
}
