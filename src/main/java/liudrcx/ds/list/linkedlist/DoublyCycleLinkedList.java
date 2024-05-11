package liudrcx.ds.list.linkedlist;

import liudrcx.ds.list.DsList;

import java.util.Iterator;

public class DoublyCycleLinkedList<T> implements DsList<T> {

  private int size = 0;

  private Node dummy;

  public DoublyCycleLinkedList() {
    dummy = new Node(null);
    dummy.next = dummy;
    dummy.prev = dummy;
  }

  private Node find(int index) {
    int i = -1;
    Node p = dummy;
    while(p.next != dummy) {
      if (index == i) {
        return p;
      }

      i++;
      p = p.next;
    }
    return p;
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
    return find(index).e;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      Node p = dummy.next;

      @Override
      public boolean hasNext() {
        return p != dummy;
      }

      @Override
      public T next() {
        Node node = p;
        p = p.next;
        return node.e;
      }
    };
  }

  class Node {
    private T e;
    private Node prev;
    private Node next;

    public Node(T e) {
      this.e = e;
    }
  }
}
