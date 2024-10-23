package algo.queue;

public class SortedArrayPriorityQueue<E extends Priority> implements PriorityQueue<E>{

  private E[] data;

  private int size;

  private int capacity;

  public SortedArrayPriorityQueue(int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Priority[capacity];
    this.size = 0;
  }

  public SortedArrayPriorityQueue() {
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
    insert(e);
    size++;
  }

  private void insert(E e) {
    int index = size - 1;
    for(; index >= 0; index--) {
      if (data[index].priority() > e.priority()) {
        data[index + 1] = data[index];
      } else {
        break;
      }
    }
    data[index + 1] = e;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      throw new IllegalStateException("queue is empty");
    }
    E result = data[size - 1];
    size--;
    return result;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new IllegalStateException("queue is empty");
    }

    return this.data[size - 1];
  }
}
