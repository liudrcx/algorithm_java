package algorithm.queue;

import algorithm.list.SinglyLinkedList;

public class LinkedListQueue<E> implements QueueDs<E>{

  private SinglyLinkedList<E> data;

  public LinkedListQueue() {
    data = new SinglyLinkedList<>();
  }

  @Override
  public boolean offer(E e) {
    if (data.isFull()) {
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
