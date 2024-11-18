package algo.binarysearch;

public class BinarySearchBasicBalanced<E extends Comparable<E>> implements BinarySearchExecutor<E>{


  @Override
  public int search(E[] data, E target) {
    if (data == null || data.length == 0) {
      return -1;
    }

    int i = 0, j = data.length;
    while(j - i > 1) {
      int m = (i + j) >>> 1;
      if (target.compareTo(data[m]) < 0) {
        j = m;
      } else {
        i = m;
      }
    }
    return data[i].compareTo(target) == 0 ? i : -1;
  }
}
