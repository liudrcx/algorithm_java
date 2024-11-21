package algo.heap;

import java.util.Arrays;
import java.util.Comparator;

public class Heap<E> {

  E[] data;

  int size;

  int capacity;

  Comparator<E> comparator;

  public Heap(int capacity, Comparator<E> comparator) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.comparator = comparator;
  }

  public Heap(Comparator<E> comparator) {
    this(16, comparator);
  }

  public Heap(E[] data, Comparator<E> comparator) {
    this.data = data;
    this.size = data.length;
    this.capacity = data.length;
    this.comparator = comparator;
    heapify();
  }

  public E peek() {
    if (size == 0) {
      throw new IllegalStateException("heap is empty");
    }

    return data[0];
  }

  public E poll() {
    if (size == 0) {
      throw new IllegalStateException("heap is empty");
    }

    E result = data[0];
    data[0] = data[size - 1];
    data[size - 1] = null; // for GC
    size--;
    down(0);
    return result;
  }

  public void offer(E val) {
    if (size == capacity) {
      throw new IllegalStateException("heap is full");
    }

    up(val);
    size++;
  }

  public void replace(E val) {
    if (size == 0) {
      throw new IllegalStateException("heap is empty");
    }

    data[0] = val;
    down(0);
  }

  private void up(E val) {
    int child = size;
    while(child > 0) {
      int parent = (child - 1) / 2;
      if (comparator.compare(val, data[parent]) < 0) {
        data[child] = data[parent];
      } else {
        break;
      }
      child = parent;
    }
    data[child] = val;
  }

  private void heapify() {
    for (int i = size / 2 - 1; i >= 0; i--) {
      down(i);
    }
  }

  private void down(int parent) {
    while(true) {
      int left = parent * 2 + 1;
      int right = left + 1;
      int tmp = parent;

      if (left < size && comparator.compare(data[left], data[tmp]) < 0) {
        tmp = left;
      }

      if (right < size && comparator.compare(data[right], data[tmp]) < 0) {
        tmp = right;
      }

      if (tmp == parent) {
        break;
      }

      swap(parent, tmp);
      parent = tmp;
    }

  }

  private void swap(int left, int right) {
    E tmpData = data[left];
    data[left] = data[right];
    data[right] = tmpData;
  }

}
