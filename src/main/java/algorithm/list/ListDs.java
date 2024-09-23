package algorithm.list;

/**
 * Linear List Data Structure Definition
 * @param <E>
 */
public interface ListDs<E> extends Iterable<E>{

  void add(int index, E e);

  void addFirst(E e);

  void addLast(E e);

  E remove(int index);

  E removeFirst();

  E removeLast();

  E get(int index);

  int size();

  boolean isEmpty();

  boolean isFull();
}
