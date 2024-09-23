package algorithm.list;

import java.util.Iterator;

public class DoublyCycleLinkedList<E> implements ListDs<E> {

  private Node dummy;

  private int size = 0;

  public DoublyCycleLinkedList() {
    dummy = new Node(null);
    dummy.next = dummy;
    dummy.prev = dummy;
  }

  @Override
  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    Node p = find(index - 1);
    Node n = p.next;
    Node c = new Node(e);

    p.next = c;
    n.prev = c;
    c.next = n;
    c.prev = p;

    size++;
  }

  @Override
  public void addFirst(E e) {
    add(0, e);
  }

  @Override
  public void addLast(E e) {
    add(size, e);
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
    Node p = dummy;
    while(p.next != dummy) {
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

      Node p = dummy.next;

      @Override
      public boolean hasNext() {
        return p != dummy;
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
