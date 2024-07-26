package aliu.ds.queue;

import aliu.ds.queue.Priority;
import aliu.ds.queue.PriorityQueue;

public class HeapPriorityQueue<E extends Priority> implements PriorityQueue<E> {

  private int capacity;
  private int size;
  private E[] data;

  public HeapPriorityQueue(int capacity) {
    this.capacity = capacity;
    data = (E[]) new Priority[capacity];
    size = 0;
  }

  @Override
  public boolean offer(E value) {
    if (isFull()) {
      return false;
    }

    up(value);
    size++;
    return true;
  }

  private void up(E value) {
    int child = size;
    int parent = (child - 1) /2;
    while(child > 0 && value.priority() > data[parent].priority()) {
      data[child] = data[parent];
      child = parent;
      parent = (child - 1) / 2;
    }
    data[child] = value;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      return null;
    }

    swap(0, size - 1);

    E result = data[size - 1];
    data[size - 1] = null;
    size--;

    down(0);
    return result;
  }

  private void down(int parent) {
    while(true) {
      int max = parent;

      int left = parent * 2 + 1;
      int right = left + 1;

      if(left < size && data[max].priority() < data[left].priority()) {
        max = left;
      }

      if (right < size && data[max].priority() < data[right].priority()) {
        max = right;
      }

      if (max == parent) {
        break;
      }

      swap(max, parent);
      parent = max;
    }
  }

  private void swap(int i, int j) {
    E t = data[i];
    data[i] = data[j];
    data[j] = t;
  }


  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }
    return data[0];
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
