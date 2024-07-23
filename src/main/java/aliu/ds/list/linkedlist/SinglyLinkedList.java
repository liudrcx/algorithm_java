package aliu.ds.list.linkedlist;


import aliu.ds.list.DsList;

import java.util.Iterator;

public class SinglyLinkedList<T> implements DsList<T> {

  private int size = 0;

  private Node head;

  public SinglyLinkedList() {
    head = new Node(null);
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
    p.next = node;
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

    Node p = find(index);
    return p.e;
  }

  @Override
  public int size() {
    return size;
  }

  private Node find(int index) {
    int i = -1;
    Node p = head;
    while(p != null) {
      if (i == index) {
        return p;
      }

      i++;
      p = p.next;
    }
    return null;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node p = head.next;

      @Override
      public boolean hasNext() {
        return p != null;
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

    public Node(T e) {
      this.e = e;
    }
  }
}
