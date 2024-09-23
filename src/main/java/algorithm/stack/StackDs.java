package algorithm.stack;

/**
 * stack structure definition
 */
public interface StackDs<E> {

  void push(E e);

  E pop();

  int size();

  boolean isEmpty();

  boolean isFull();
}
