package liudrcx.algo.queue;

public class SortedArrayPriorityQueue<E extends Priority> implements PriorityQueue<E>{

  private int capacity;
  private int size;
  private E[] data;

  public SortedArrayPriorityQueue(int capacity) {
    this.capacity = capacity;
    data = (E[]) new Priority[capacity];
  }

  @Override
  public boolean offer(E value) {
    if (isFull()) {
      return false;
    }
    insert(value);
    size++;
    return true;
  }

  private void insert(E value) {
    int i = size - 1;
    while(i >= 0 && data[i].priority() > value.priority()) {
      data[i + 1] = data[i];
      i--;
    }
    data[i + 1] = value;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      return null;
    }
    E value = data[size - 1];
    data[size - 1] = null;
    size--;
    return value;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }
    E value = data[size - 1];
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
