package algo.queue;

public class UnsortedArrayPriorityQueue<E extends Priority> implements PriorityQueue<E>{

  private E[] data;

  private int capacity = 0;

  private int size = 0;

  public UnsortedArrayPriorityQueue(int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Priority[capacity];
  }

  public UnsortedArrayPriorityQueue() {
    this(16);
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
      throw new IllegalStateException("queue is full");
    }

    data[size] = e;
    size++;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      throw new IllegalStateException("queue is empty");
    }

    int maxIndex = selectMaxPriorityIndex();
    E result = data[maxIndex];

    swap(maxIndex, size - 1);
    size--;
    data[size] = null; //for GC
    return result;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new IllegalStateException("queue is empty");
    }
    return data[selectMaxPriorityIndex()];
  }

  private int selectMaxPriorityIndex() {
    int maxIndex = 0;
    Priority max = data[0];

    for (int i = 1; i < size; i++) {
      if (max.priority() < data[i].priority()) {
        maxIndex = i;
        max = data[i];
      }
    }

    return maxIndex;
  }

  private void swap(int leftIndex, int rightIndex) {
    E t = data[leftIndex];
    data[leftIndex] = data[rightIndex];
    data[rightIndex] = t;
  }
}
