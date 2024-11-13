package algo.queue;

import java.util.Iterator;

public class ArrayCycleQueue<E> implements Queue<E>, Iterable<E> {

  private int size;

  private int capacity;

  private E[] data;

  private int head;

  private int tail;

  public ArrayCycleQueue(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.head = 0;
    this.tail = 0;
    this.data = (E[]) new Object[capacity];
  }

  public ArrayCycleQueue() {
    this(16);
  }

  ArrayCycleQueue(E[] data) {
    this.data = data;
    this.size = data.length;
    this.capacity = data.length;
    this.head = 0;
    this.tail = data.length;
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

    data[tail] = e;
    tail = (tail + 1) % capacity;
    size++;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }

    E result = data[head];
    head = (head + 1) % capacity;
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
      int iterIndex = 0;

      @Override
      public boolean hasNext() {
        return iterIndex < size;
      }

      @Override
      public E next() {
        E result = data[index];
        index = (index + 1) % capacity;
        iterIndex++;
        return result;
      }
    };
  }
}
