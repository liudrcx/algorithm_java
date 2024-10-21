package algo.heap;

public class MinHeap<E extends Comparable<E>> extends BaseHeap<E>{

  public MinHeap(int capacity) {
    super(capacity, true);
  }

  public MinHeap() {
    this(16);
  }

  public MinHeap(E[] data) {
    super(data, true);
  }
}
