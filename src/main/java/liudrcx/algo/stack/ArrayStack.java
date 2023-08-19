package liudrcx.algo.stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {

  private E[] data;
  private int capacity;
  private int size = 0;
  private int top = 0;

  public ArrayStack(int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      int p = top;

      @Override
      public boolean hasNext() {
        return p > 0;
      }

      @Override
      public E next() {
        return data[--p];
      }
    };
  }

  @Override
  public boolean push(E value) {
    if (isFull()) {
      return false;
    }
    data[top] = value;
    top++;
    size++;
    return true;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      return null;
    }
    E value = data[--top];
    data[top] = null;
    size--;
    return value;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }
    return data[top - 1];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean isFull() {
    return size == capacity;
  }

  @Override
  public int size() {
    return size;
  }
}
