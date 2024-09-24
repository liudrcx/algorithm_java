package algorithm.queue;

import algorithm.list.DynamicArray;

public class DynamicArrayQueue<E> implements QueueDs<E>{

  private DynamicArray<E> data;

  public DynamicArrayQueue() {
    data = new DynamicArray<>();
  }

  @Override
  public boolean offer(E e) {
    if (isFull()) {
      return false;
    }
    data.addLast(e);
    return true;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      throw new RuntimeException("queue is empty");
    }
    return data.removeFirst();
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new RuntimeException("queue is empty");
    }
    return data.get(0);
  }

  @Override
  public boolean isEmpty() {
    return data.isEmpty();
  }

  @Override
  public boolean isFull() {
    return data.isFull();
  }

  @Override
  public int size() {
    return data.size();
  }
}
