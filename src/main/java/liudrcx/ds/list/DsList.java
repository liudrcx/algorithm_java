package liudrcx.ds.list;

public interface DsList<T> extends Iterable<T>{

  void add(int index, T e);

  void addFirst(T e);

  void addLast(T e);

  T get(int index);

  T remove(int index);

  T removeFirst();

  T removeLast();

  int size();
}
