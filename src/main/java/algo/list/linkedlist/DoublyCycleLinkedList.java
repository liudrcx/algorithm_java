package algo.list.linkedlist;

import algo.list.List;

import java.util.Iterator;

public class DoublyCycleLinkedList<E> implements List<E>, Iterable<E> {

  private Node head;

  private int size;

  public DoublyCycleLinkedList() {
    head = new Node(null);
    head.prev = head;
    head.next = head;

    size = 0;
  }

  protected DoublyCycleLinkedList(E[] array) {
    this();

    Node prev = head;
    for (E e : array) {
      Node current = new Node(e);
      Node next = prev.next;

      prev.next = current;
      next.prev = current;
      current.prev = prev;
      current.next = next;

      prev = prev.next;
    }

    size = array.length;
  }

  @Override
  public void add(int index, E e) {
    checkAddIndex(index);

    Node prev = findPreviousNodeByIndex(index);
    Node next = prev.next;
    Node current = new Node(e);

    prev.next = current;
    next.prev = current;
    current.prev = prev;
    current.next = next;

    size++;
  }

  @Override
  public void addFirst(E e) {
    add(0, e);
  }

  @Override
  public void addLast(E e) {
    add(size, e);
  }

  @Override
  public E remove(int index) {
    checkFetchIndex(index);

    Node prev = findPreviousNodeByIndex(index);
    Node current = prev.next;
    Node next = current.next;

    prev.next = next;
    next.prev = prev;

    size--;
    return current.data;
  }

  @Override
  public E removeFirst() {
    return remove(0);
  }

  @Override
  public E removeLast() {
    return remove(size - 1);
  }

  @Override
  public E get(int index) {
    checkFetchIndex(index);
    Node prev = findPreviousNodeByIndex(index);
    return prev.next.data;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  private Node findPreviousNodeByIndex(int index) {
    Node current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current;
  }

  private void checkFetchIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("invalid index: " + index);
    }
  }

  private void checkAddIndex(int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("invalid index: " + index);
    }
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      Node current = head.next;

      @Override
      public boolean hasNext() {
        return current != head;
      }

      @Override
      public E next() {
        E result = current.data;
        current = current.next;
        return result;
      }
    };
  }

  class Node {
    E data;

    Node prev;

    Node next;

    public Node(E data) {
      this.data = data;
    }
  }
}
