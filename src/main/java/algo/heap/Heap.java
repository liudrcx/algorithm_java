package algo.heap;

public interface Heap<E extends Comparable<E>>{

  int size();

  boolean isEmpty();

  boolean isFull();

  E peek();

  E poll();

  void replace(E e);

  void offer(E e);
}
