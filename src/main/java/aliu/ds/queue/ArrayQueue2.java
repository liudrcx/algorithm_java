package aliu.ds.queue;

import aliu.ds.queue.Queue;

import java.util.Iterator;

public class ArrayQueue2<E> implements Queue<E>, Iterable<E>{

  private E[] data;

  private int capacity;

  private int size = 0;
  private int head = 0;
  private int tail = 0;

  public ArrayQueue2(int capacity) {
    this.capacity = capacity;
    data = (E[]) new Object[capacity];
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      int count = 0;
      int p = head;

      @Override
      public boolean hasNext() {
        return count < size;
      }

      @Override
      public E next() {
        E value = data[p];
        p = (p + 1) % capacity;
        count++;
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
    tail = (tail + 1) % capacity;
    size++;
    return true;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      return null;
    }

    E value = data[head];
    data[head] = null;
    head = (head + 1) % capacity;
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
