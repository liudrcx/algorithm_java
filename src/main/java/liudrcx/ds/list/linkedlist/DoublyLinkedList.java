package liudrcx.ds.list.linkedlist;

import liudrcx.ds.list.DsList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements DsList<T> {

  private int size = 0;

  private Node head;

  private Node tail;

  public DoublyLinkedList() {
    head = new Node(null);
    tail = new Node(null);
    head.next = tail;
    tail.prev = head;
    size = 0;
  }

  private Node find(int index) {
    int i = -1;
    Node p = head;
    while(p != tail) {
      if (i == index) {
        return p;
      }

      i++;
      p = p.next;
    }
    return null;
  }

  @Override
  public void addFirst(T e) {
    add(0, e);
  }

  @Override
  public void addLast(T e) {
    add(size, e);
  }

  @Override
  public void add(int index, T e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    Node p = find(index - 1);
    Node next = p.next;
    Node node = new Node(e);

    node.next = next;
    node.prev = p;
    p.next = node;
    next.prev = node;
    size++;
  }

  @Override
  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    Node p = find(index - 1);
    Node node = p.next;
    Node next = node.next;

    p.next = next;
    next.prev = p;
    size--;

    return node.e;
  }

  @Override
  public T removeFirst() {
    return remove(0);
  }

  @Override
  public T removeLast() {
    return remove(size - 1);
  }

  @Override
  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    Node node = find(index);
    return node.e;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      Node p = head.next;

      @Override
      public boolean hasNext() {
        return p != tail;
      }

      @Override
      public T next() {
        T e = p.e;
        p = p.next;
        return e;
      }
    };
  }

  class Node {
    private T e;
    private Node next;

    private Node prev;

    public Node(T e) {
      this.e = e;
    }
  }
}
