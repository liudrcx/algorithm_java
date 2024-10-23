package algo.queue;

public interface Queue<E> {

  int size();

  boolean isFull();

  boolean isEmpty();

  void offer(E e);

  E poll();

  E peek();

}
