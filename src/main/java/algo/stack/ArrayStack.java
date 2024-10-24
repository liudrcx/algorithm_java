package algo.stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {

  private int capacity;

  private int size;

  private E[] data;

  public ArrayStack(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.data = (E[]) new Object[capacity];
  }

  public ArrayStack() {
    this(16);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isFull() {
    return size == capacity;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void push(E e) {
    if (isFull()) {
      throw new IllegalStateException("stack is full");
    }

    data[size] = e;
    size++;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }
    E result = data[size - 1];
    size--;
    return result;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }
    return data[size - 1];
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      int index = size - 1;

      @Override
      public boolean hasNext() {
        return index >= 0;
      }

      @Override
      public E next() {
        E result = data[index];
        index--;
        return result;
      }
    };
  }
}
