package algo.stack;

public interface Stack<E> {

  int size();

  boolean isFull();

  boolean isEmpty();

  void push(E e);

  E pop();

  E peek();
}
