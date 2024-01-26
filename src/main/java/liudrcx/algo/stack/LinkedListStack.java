package liudrcx.algo.stack;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable<E>{

  private int capacity;
  private int size = 0;
  private Node head = new Node(null);

  public LinkedListStack(int capacity) {
    this.capacity = capacity;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      Node p = head.next;

      @Override
      public boolean hasNext() {
        return p != null;
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
  public boolean push(E value) {
    if (isFull()) {
      return false;
    }

    Node node = new Node(value);
    node.next = head.next;
    head.next = node;
    size++;
    return true;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      return null;
    }

    Node node = head.next;
    E value = node.value;
    head.next = node.next;
    size--;
    return value;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }
    Node node = head.next;
    return node.value;
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
    Node next;

    public Node(E value) {
      this.value = value;
    }
  }
}
