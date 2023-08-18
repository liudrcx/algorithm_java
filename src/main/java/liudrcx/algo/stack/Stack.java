package liudrcx.algo.stack;

public interface Stack<E> {

  boolean push(E value);

  E pop();

  E peek();

  boolean isEmpty();

  boolean isFull();

  int size();
}
