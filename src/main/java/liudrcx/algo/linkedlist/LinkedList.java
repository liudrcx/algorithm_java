package liudrcx.algo.linkedlist;

public interface LinkedList<T> extends Iterable<T> {

  void addFirst(T e);

  void addLast(T e);

  void add(int index, T e);

  T remove(int index);

  T removeFirst();

  T removeLast();

  T get(int index);

  int size();
}
