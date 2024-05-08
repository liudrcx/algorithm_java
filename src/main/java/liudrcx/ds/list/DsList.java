package liudrcx.ds.list;

public interface DsList<E> extends Iterable<E>{

  void addFirst(E e);

  void addLast(E e);

  void add(int index, E e);

  E removeFirst();

  E removeLast();

  E remove(int index);

  /**
   * @param e
   * @return index of given element, return -1 if element not exists
   */
  int removeByValue(E e);

  E get(int index);

  /**
   * @param e
   * @return index of given element, return -1 if element not exists
   */
  int findByValue(E e);

  int size();
}
