package algo.stack;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable<E>{

  private int capacity;

  private int size;

  private Node head;

  public LinkedListStack(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.head = new Node(null);
  }

  public LinkedListStack() {
    this(16);
  }

  /**
   * for testing
   */
  protected LinkedListStack(E[] data) {
    this();

    this.size = data.length;
    this.capacity = data.length;

    for (E e : data) {
      Node node = new Node(e);
      node.next = head.next;
      head.next = node;
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
  public void push(E e) {
    if (isFull()) {
      throw new IllegalStateException("stack is full");
    }
    Node newNode = new Node(e);
    newNode.next = head.next;
    head.next = newNode;
    size++;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }
    Node first = head.next;
    head.next = first.next;
    size--;
    return first.e;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }
    return head.next.e;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      Node current = head.next;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public E next() {
        E result = current.e;
        current = current.next;
        return result;
      }
    };
  }

  class Node {
    E e;
    Node next;

    public Node(E e) {
      this.e = e;
    }
  }
}
