package liudrcx.ds.list;

public interface DsList<E> extends Iterable<E>{

  void addFirst(E e);

  void addLast(E e);

  void add(int index, E e);

  E removeFirst();

  E removeLast();

  E remove(int index);

  E get(int index);

  int size();
}
