package algorithm.list;

/**
 * Linear List Data Structure Definition
 * @param <E>
 */
public interface ListDs<E> extends Iterable<E>{

  /**
   *
   * @param index
   * @param e
   */
  void add(int index, E e);

  /**
   *
   * @param e
   */
  void addFirst(E e);

  void addLast(E e);

  E remove(int index);

  E removeFirst();

  E removeLast();

  int size();

  boolean isEmpty();

  boolean isFull();
}
