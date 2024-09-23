package algorithm.stack;

import algorithm.list.SinglyLinkedList;

public class LinkedListStack<E> implements StackDs<E>{

  private SinglyLinkedList<E> data;

  public LinkedListStack() {
    data = new SinglyLinkedList<>();
  }

  @Override
  public void push(E e) {
    if (data.isFull()) {
      throw new RuntimeException("stack is full");
    }
    data.addLast(e);
  }

  @Override
  public E pop() {
    if (data.isEmpty()) {
      throw new RuntimeException("stack is empty");
    }
    return data.removeLast();
  }

  @Override
  public int size() {
    return data.size();
  }

  @Override
  public boolean isEmpty() {
    return data.isEmpty();
  }

  @Override
  public boolean isFull() {
    return data.isFull();
  }
}
