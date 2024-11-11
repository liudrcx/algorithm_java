package algorithm.stack;

public class DynamicArrayStack<E> implements StackDs<E> {

  private DynamicArray<E> data;

  public DynamicArrayStack(int capacity) {
    data = new DynamicArray<>(capacity);
  }

  public DynamicArrayStack() {
    this(16);
  }

  @Override
  public void push(E e) {
    if (data.isFull()) {
      throw new RuntimeException("stack is full");
    }
    data.addLast(e);
  }

  @Override
  public E pop() {
    if (data.isEmpty()) {
      throw new RuntimeException("stack is empty");
    }
    return data.removeLast();
  }

  @Override
  public int size() {
    return data.size();
  }

  @Override
  public boolean isEmpty() {
    return data.isEmpty();
  }

  @Override
  public boolean isFull() {
    return data.isFull();
  }
}
