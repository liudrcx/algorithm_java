package liudrcx.algo.queue;

import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E>, Iterable<E>{

  private E[] data;
  private int size = 0;
  private int head = 0;
  private int tail = 0;

  public ArrayQueue(int capacity) {
    this.data = (E[]) new Object[capacity + 1];
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
        p = (p + 1) % data.length;
        return value;
      }
    };
  }

  @Override
  public boolean offer(E value) {
    if (isFull()) {
      return false;
    }

    data[tail] = value;
    tail = (tail + 1) % this.data.length;
    size++;
    return true;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      return null;
    }

    E value = data[head];
    data[head] = null; //for GC
    head = (head + 1) % this.data.length;
    size--;
    return value;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }

    return data[head];
  }

  @Override
  public boolean isEmpty() {
    return head == tail;
  }

  @Override
  public boolean isFull() {
    return (tail + 1) % this.data.length == head;
  }

  @Override
  public int size() {
    return size;
  }
}
