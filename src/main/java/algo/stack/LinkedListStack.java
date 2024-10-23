package algo.stack;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable<E>{

  private int capacity;

  private int size;

  private Node dummy;

  public LinkedListStack(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.dummy = new Node(null);
  }

  public LinkedListStack() {
    this(16);
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
    newNode.next = dummy.next;
    dummy.next = newNode;
    size++;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }
    Node first = dummy.next;
    dummy.next = first.next;
    size--;
    return first.e;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }
    return dummy.next.e;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      Node current = dummy.next;

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
