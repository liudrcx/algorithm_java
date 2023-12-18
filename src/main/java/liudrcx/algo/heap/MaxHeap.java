package liudrcx.algo.heap;

public class MaxHeap<T extends Comparable<T>> {

  private T[] data;
  private int size;
  private int capacity;

  public MaxHeap(int capacity) {
    this.data = (T[]) new Comparable[capacity];
  }

  public T peek() {
    if (isEmpty()) {
      return null;
    }
    return data[0];
  }

  public T poll() {
    if (isEmpty()) {
      return null;
    }

    T deleted = data[0];
    swap(0, size - 1);
    size--;
    down(0);
    return deleted;
  }

  public boolean offer(T value) {
    if (isFull()) {
      return false;
    }

    up(value);
    size++;
    return true;
  }

  public void up(T value) {
    int child = size;
    while(child > 0) {
      int parent = (child - 1) / 2;
      if (data[parent].compareTo(value) < 0) {
        data[child] = data[parent];
      } else {
        break;
      }
      child = parent;
    }
    data[child] = value;
  }

  private void heapify() {
    for(int i = size / 2 - 1; i >= 0; i--) {
      down(i);
    }
  }

  private void down(int parent) {
    while(true) {
      int max = parent;

      int left = parent * 2 + 1;
      int right = left + 1;

      if (left < size && data[max].compareTo(data[left]) < 0) {
        max = left;
      }
      if (right < size && data[max].compareTo(data[right]) < 0) {
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
    T t = data[i];
    data[i] = data[j];
    data[j] = t;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == data.length;
  }

  public int size() {
    return size;
  }
}
