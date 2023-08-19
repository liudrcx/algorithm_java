package liudrcx.algo.dequeue;

import java.util.Iterator;

public class LinkedListDeque<E> implements Deque<E>, Iterable<E>{

  private int capacity = 0;
  private int size = 0;
  private Node sentinel = new Node(null);

  public LinkedListDeque(int capacity) {
    this.capacity = capacity;
    sentinel.next = sentinel;
    sentinel.prev = sentinel;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      Node p = sentinel.next;

      @Override
      public boolean hasNext() {
        return p != sentinel;
      }

      @Override
      public E next() {
        E value = p.value;
        p = p.next;
        return value;
      }
    };
  }

  @Override
  public boolean offerFirst(E e) {
    if (isFull()) {
      return false;
    }
    Node first = sentinel;
    Node next = sentinel.next;

    Node node = new Node(e);
    node.next = next;
    node.prev = first;
    first.next = node;
    next.prev = node;
    size++;
    return true;
  }

  @Override
  public boolean offerLast(E e) {
    if (isFull()) {
      return false;
    }
    Node first = sentinel.prev;
    Node next = sentinel;

    Node node = new Node(e);
    node.next = next;
    node.prev = first;
    first.next = node;
    next.prev = node;
    size++;
    return true;
  }

  @Override
  public E pollFirst() {
    if (isEmpty()) {
      return null;
    }
    Node first = sentinel;
    Node polled = sentinel.next;
    Node next = polled.next;
    first.next = next;
    next.prev = first;
    size--;
    return polled.value;
  }

  @Override
  public E pollLast() {
    if (isEmpty()) {
      return null;
    }
    Node polled = sentinel.prev;
    Node first = polled.prev;
    Node next = sentinel;
    first.next = next;
    next.prev = first;
    size--;
    return polled.value;
  }

  @Override
  public E peekFirst() {
    if (isEmpty()) {
      return null;
    }
    return sentinel.next.value;
  }

  @Override
  public E peekLast() {
    if (isEmpty()) {
      return null;
    }
    return sentinel.prev.value;
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

  class Node {
    E value;
    Node prev;
    Node next;

    public Node(E value) {
      this.value = value;
    }
  }
}
