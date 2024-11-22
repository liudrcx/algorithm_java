package algo.queue;

public interface Deque<E> {

  void offerFirst(E e);

  void offerLast(E e);

  E pollFirst();

  E pollLast();

  E peekFirst();

  E peekLast();

  boolean isEmpty();

  boolean isFull();

  int size();
}
