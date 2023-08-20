package liudrcx.algo.queue;

public class UnSortedArrayPriorityQueue<E extends Priority> implements PriorityQueue<E>{

  private int capacity;
  private int size;
  private E[] data;

  public UnSortedArrayPriorityQueue(int capacity) {
    this.capacity = capacity;
    data = (E[]) new Priority[capacity];
  }

  @Override
  public boolean offer(E value) {
    if (isFull()) {
      return false;
    }
    data[size++] = value;
    return true;
  }

  private int findMax() {
    int max = 0;
    for (int i = 1; i < size; i++) {
      if (data[max].priority() < data[i].priority()) {
        max = i;
      }
    }
    return max;
  }

  private void remove(int index) {
    if (index < size - 1) {
      System.arraycopy(data, index + 1, data, index, size - index - 1);
    }
    data[--size] = null;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      return null;
    }

    int max = findMax();
    E value = data[max];
    //remove max;
    remove(max);
    return value;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }

    int max = findMax();
    E value = data[max];
    return value;
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
