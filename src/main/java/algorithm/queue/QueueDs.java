package algorithm.queue;

/**
 * Data Structure for Queue Definition
 * @param <E>
 */
public interface QueueDs<E> {

  boolean offer(E e);

  E poll();

  E peek();

  boolean isEmpty();

  boolean isFull();

  int size();
}
