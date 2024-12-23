package algo.queue;

import java.util.Iterator;

public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

  private int size;

  private int capacity;

  private Node head;

  private Node tail;

  public LinkedListQueue(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    head = new Node(null);
    tail = head;
    head.next = head;
  }

  public LinkedListQueue() {
    this(16);
  }

  protected LinkedListQueue(E[] data) {
    this();

    size = data.length;
    capacity = size;

    Node prev = head;
    for (E e : data) {
      Node current = new Node(e);
      current.next = prev.next;
      prev.next = current;

      prev = prev.next;
      tail = prev;
    }
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
      throw new IllegalArgumentException("queue is full");
    }

    Node node = new Node(e);
    tail.next = node;
    node.next = head;
    tail = node;
    size++;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }

    Node current = head.next;
    head.next = current.next;

    size--;
    return current.data;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty");
    }
    return head.next.data;
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
        Node result = current;
        current = current.next;
        return result.data;
      }
    };
  }

  private class Node {
    E data;

    Node next;

    public Node(E data) {
      this.data = data;
    }
  }
}
