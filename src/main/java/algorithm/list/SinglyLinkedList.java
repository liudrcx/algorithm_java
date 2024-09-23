package algorithm.list;

import java.util.Iterator;

public class SinglyLinkedList<E> implements ListDs<E> {

  private Node head = new Node(null);

  private int size = 0;

  @Override
  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    Node p = find(index - 1);

    Node c = new Node(e);
    c.next = p.next;
    p.next = c;
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
    p.next = c.next;
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

    Node node = find(index);
    return node.e;
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
    while(p != null) {
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
        return p != null;
      }

      @Override
      public E next() {
        Node node = p;
        p = p.next;
        return node.e;
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
