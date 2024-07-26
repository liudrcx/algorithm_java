package aliu.ds.queue;

import aliu.ds.queue.Queue;

import java.util.Iterator;

public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

  private int capacity;
  private int size = 0;

  private Node head = new Node(null);
  private Node tail = head;

  public LinkedListQueue(int capacity) {
    this.capacity = capacity;
    head.next = head;
  }

  @Override
  public boolean offer(E value) {
    if (isFull()) {
      return false;
    }

    Node node = new Node(value);
    node.next = head;
    tail.next = node;
    tail = node;
    size++;
    return true;
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      return null;
    }

    Node first = head.next;
    head.next = first.next;
    if (first == tail) {
      tail = head;
    }
    size--;
    return first.value;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }
    return head.next.value;
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

      Node p = head.next;

      @Override
      public boolean hasNext() {
        return p != head;
      }

      @Override
      public E next() {
        Node node = p;
        p = p.next;
        return node.value;
      }
    };
  }

  class Node {
    E value;
    Node next;

    public Node(E value) {
      this.value = value;
    }
  }
}
