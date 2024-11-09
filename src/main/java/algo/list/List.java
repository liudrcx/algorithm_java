package algo.list;

public interface List<E> {

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
