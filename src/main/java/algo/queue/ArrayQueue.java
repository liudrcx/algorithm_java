package algo.queue;

import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E>, Iterable<E>{

  private E[] data;

  private int size;

  private int capacity;

  private int head;

  private int tail;

  public ArrayQueue(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.data = (E[]) new Object[capacity];
    this.head = 0;
    this.tail = 0;
  }

  public ArrayQueue() {
    this(16);
  }

  /**
   * for testing
   * @param data
   */
  ArrayQueue(E[] data) {
    this.data = data;
    this.size = data.length;
    this.capacity = data.length;
    this.head = 0;
    this.tail = size - 1;
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
  public void offer(E e) {
    if (isFull()) {
      throw new IllegalArgumentException("queue is full");
    }
    if (tail == capacity) {
      System.arraycopy(data, head, data, 0, size);
      head = 0;
      tail = size;
    }

    data[tail] = e;
    tail++;
    size++;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }
    E result = data[head];
    data[head] = null; // for GC
    head++;
    size--;
    return result;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }
    return data[head];
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      int index = head;

      @Override
      public boolean hasNext() {
        return index < tail;
      }

      @Override
      public E next() {
        return data[index++];
      }
    };
  }
}
