package algo.queue;

import java.util.Iterator;

public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

  Node sentinel;

  int size;

  int capacity;

  public LinkedListDeque(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.sentinel = new Node();
    sentinel.next = sentinel;
    sentinel.prev = sentinel;
  }

  public LinkedListDeque() {
    this(16);
  }

  @Override
  public void offerFirst(E e) {
    if (isFull()) {
      throw new IllegalArgumentException("queue is full");
    }

    Node prev = sentinel;
    Node next = sentinel.next;
    Node current = new Node(e);

    prev.next = current;
    next.prev = current;
    current.prev = prev;
    current.next = next;

    size++;
  }

  @Override
  public void offerLast(E e) {
    if (isFull()) {
      throw new IllegalArgumentException("queue is full");
    }

    Node prev = sentinel.prev;
    Node next = sentinel;
    Node current = new Node(e);

    prev.next = current;
    next.prev = current;
    current.prev = prev;
    current.next = next;

    size++;
  }

  @Override
  public E pollFirst() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }

    Node prev = sentinel;
    Node current = sentinel.next;
    Node next = current.next;

    prev.next = next;
    next.prev = prev;

    size--;
    return current.val;
  }

  @Override
  public E pollLast() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }

    Node prev = sentinel.prev.prev;
    Node current = sentinel.prev;
    Node next = sentinel;

    prev.next = next;
    next.prev = prev;

    size--;
    return current.val;
  }

  @Override
  public E peekFirst() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }
    return sentinel.next.val;
  }

  @Override
  public E peekLast() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }
    return sentinel.prev.val;
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

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      Node current = sentinel.next;

      @Override
      public boolean hasNext() {
        return current != sentinel;
      }

      @Override
      public E next() {
        E result = current.val;
        current = current.next;
        return result;
      }
    };
  }


  class Node {
    E val;

    public Node(E val) {
      this.val = val;
    }

    public Node() {}

    Node prev;

    Node next;

  }
}
