package algo.queue;

public class HeapPriorityQueue<E extends Priority> implements PriorityQueue<E>{

  private E[] data;

  private int capacity;

  private int size;

  public HeapPriorityQueue(int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Priority[capacity];
    this.size = 0;
  }

  public HeapPriorityQueue() {
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

    up(e);
    size++;
  }

  private void up(E e) {
    int childIndex = size;
    while(childIndex > 0) {
      int parentIndex = (childIndex - 1) / 2;
      if (data[parentIndex].priority() < e.priority()) {
        data[childIndex] = data[parentIndex];
      } else {
        break;
      }
      childIndex = parentIndex;
    }
    data[childIndex] = e;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      throw new IllegalStateException("queue is empty");
    }

    E result = data[0];
    swap(0, size - 1);
    size--;
    data[size] = null; // for GC

    down(0);
    return result;
  }

  private void down(int index) {
    while(true) {
      int leftIndex = (index * 2) + 1;
      int rightIndex = leftIndex + 1;
      int maxIndex = index;

      if (leftIndex < size && data[leftIndex].priority() > data[maxIndex].priority()) {
        maxIndex = leftIndex;
      }

      if (rightIndex < size && data[rightIndex].priority() > data[maxIndex].priority()) {
        maxIndex = rightIndex;
      }

      if (maxIndex == index) {
        break;
      }

      swap(maxIndex, index);
      index = maxIndex;
    }
  }

  private void swap(int leftIndex, int rightIndex) {
    E t = data[leftIndex];
    data[leftIndex] = data[rightIndex];
    data[rightIndex] = t;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new IllegalStateException("queue is empty");
    }
    return data[0];
  }
}
