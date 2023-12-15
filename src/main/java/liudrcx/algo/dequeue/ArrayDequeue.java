package liudrcx.algo.dequeue;

import java.util.Iterator;

public class ArrayDequeue<E> implements Deque<E>, Iterable<E>{

  private int size = 0;
  private E[] data;
  private int head = 0;
  private int tail = 0;

  public ArrayDequeue(int capacity) {
    data = (E[]) new Object[capacity + 1];
  }

  private int inc(int i) {
    if (i + 1 >= data.length) {
      return 0;
    }
    return i + 1;
  }

  private int dec(int i) {
    if (i - 1 < 0) {
      return data.length - 1;
    }
    return i - 1;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      int p = head;

      @Override
      public boolean hasNext() {
        return p != tail;
      }

      @Override
      public E next() {
        E value = data[p];
        p = inc(p);
        return value;
      }
    };
  }

  @Override
  public boolean offerFirst(E e) {
    if (isFull()) {
      return false;
    }
    head = dec(head);
    data[head] = e;
    size++;
    return true;
  }

  @Override
  public boolean offerLast(E e) {
    if (isFull()) {
      return false;
    }
    data[tail] = e;
    tail = inc(tail);
    size++;
    return true;
  }

  @Override
  public E pollFirst() {
    if (isEmpty()) {
      return null;
    }
    E value = data[head];
    data[head] = null;
    head = inc(head);
    size--;
    return value;
  }

  @Override
  public E pollLast() {
    if (isEmpty()) {
      return null;
    }
    tail = dec(tail);
    E value = data[tail];
    data[tail] = null;
    size--;
    return value;
  }

  @Override
  public E peekFirst() {
    if (isEmpty()) {
      return null;
    }
    return data[head];
  }

  @Override
  public E peekLast() {
    if (isEmpty()) {
      return null;
    }
    return data[dec(tail)];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean isFull() {
    return size == data.length - 1;
  }

  @Override
  public int size() {
    return size;
  }
}
