package algo.heap;

public class MaxHeap<E extends Comparable<E>> extends BaseHeap<E>{

  public MaxHeap(int capacity) {
    super(capacity, false);
  }

  public MaxHeap() {
    this(16);
  }

  public MaxHeap(E[] data) {
    super(data, false);
  }
}
