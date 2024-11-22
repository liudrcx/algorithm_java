package algo.queue;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E>, Iterable<E> {

  private E[] data;

  private int size;

  private int capacity;

  private int head;

  private int tail;

  public ArrayDeque(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.head = 0;
    this.tail = 0;
    this.data = (E[]) new Object[capacity];
  }

  @Override
  public void offerFirst(E e) {
    if (isFull()) {
      throw new IllegalArgumentException("queue is full");
    }

    head = dec(head);
    data[head] = e;
    size++;
  }

  @Override
  public void offerLast(E e) {
    if (isFull()) {
      throw new IllegalArgumentException("queue is full");
    }

    data[tail] = e;
    tail = inc(tail);
    size++;
  }

  @Override
  public E pollFirst() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }

    E result = data[head];
    data[head] = null;
    head = inc(head);
    size--;
    return result;
  }

  @Override
  public E pollLast() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }

    tail = dec(tail);
    E result = data[tail];
    data[tail] = null;
    size--;
    return result;
  }

  @Override
  public E peekFirst() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }
    return data[head];
  }

  @Override
  public E peekLast() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }
    return data[dec(tail)];
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

  private int inc(int i) {
    if (i + 1 >= capacity) {
      return 0;
    }
    return i + 1;
  }

  private int dec(int i) {
    if (i - 1 < 0) {
      return capacity - 1;
    }
    return i - 1;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      int index = head;

      int count = 0;

      @Override
      public boolean hasNext() {
        return count < size;
      }

      @Override
      public E next() {
        E result = data[index];
        index = inc(index);
        count++;
        return result;
      }
    };
  }
}
