package algorithm.queue;

public class CycleArrayQueue<E> implements QueueDs<E> {

  private int size;

  private int capacity;

  private E[] data;

  private int head;

  private int tail;

  public CycleArrayQueue(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    data = (E[]) new Object[capacity];
    head = 0;
    tail = 0;
  }

  public CycleArrayQueue() {
    this(16);
  }

  @Override
  public boolean offer(E e) {
    if (isFull()) {
      return false;
    }

    data[tail] = e;
    tail = (tail + 1) % capacity;
    size++;

    return true;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      throw new RuntimeException("queue is empty");
    }

    E e = data[head];
    head = (head + 1) % capacity;
    size--;

    return e;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new RuntimeException("queue is empty");
    }
    return data[head];
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
