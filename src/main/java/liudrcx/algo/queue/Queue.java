package liudrcx.algo.queue;

public interface Queue<E> {

  boolean offer(E value);

  E poll();

  E peek();

  boolean isEmpty();

  boolean isFull();

  int size();
}
