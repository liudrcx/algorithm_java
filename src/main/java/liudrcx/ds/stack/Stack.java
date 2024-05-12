package liudrcx.ds.stack;

public interface Stack<E> extends Iterable<E>{

  boolean push(E value);

  E pop();

  E peek();

  boolean isEmpty();

  boolean isFull();

  int size();
}
