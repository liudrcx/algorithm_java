package algorithm.list;

import java.util.Iterator;

public class DoublyLinkedList<E> implements ListDs<E> {

  private Node head;

  private Node tail;

  private int size = 0;

  public DoublyLinkedList() {
    head = new Node(null);
    tail = new Node(null);
    head.next = tail;
    tail.prev = head;
  }

  @Override
  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    Node p = find(index - 1);
    Node n = p.next;
    Node c = new Node(e);

    c.next = n;
    c.prev = p;
    p.next = c;
    n.prev = c;

    size++;
  }

  @Override
  public void addFirst(E e) {
    add(0, e);
  }

  @Override
  public void addLast(E e) {
    add(size , e);
  }

  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    Node p = find(index - 1);
    Node c = p.next;
    Node n = c.next;

    p.next = n;
    n.prev = p;

    size--;
    return c.e;
  }

  @Override
  public E removeFirst() {
    return remove(0);
  }

  @Override
  public E removeLast() {
    return remove(size - 1);
  }

  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    Node c = find(index);
    return c.e;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean isFull() {
    return false;
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
    return p;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      Node p = head.next;

      @Override
      public boolean hasNext() {
        return p != tail;
      }

      @Override
      public E next() {
        E e = p.e;
        p = p.next;
        return e;
      }
    };
  }

  class Node {
    E e;

    Node next;

    Node prev;

    public Node(E e) {
      this.e = e;
    }
  }
}
