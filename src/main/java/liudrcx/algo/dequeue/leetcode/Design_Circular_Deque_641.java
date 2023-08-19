package liudrcx.algo.dequeue.leetcode;

import liudrcx.algo.dequeue.LinkedListDeque;

/*
*   https://leetcode.com/problems/design-circular-deque/
* */
public class Design_Circular_Deque_641 {

  class MyCircularDeque {

    private int capacity = 0;
    private int size = 0;
    private Node sentinel = new Node(-1);

    public MyCircularDeque(int k) {
      this.capacity = k;
      sentinel.next = sentinel;
      sentinel.prev = sentinel;
    }

    public boolean insertFront(int value) {
      if (isFull()) {
        return false;
      }
      Node first = sentinel;
      Node next = sentinel.next;

      Node node = new Node(value);
      node.next = next;
      node.prev = first;
      first.next = node;
      next.prev = node;
      size++;
      return true;
    }

    public boolean insertLast(int value) {
      if (isFull()) {
        return false;
      }
      Node first = sentinel.prev;
      Node next = sentinel;

      Node node = new Node(value);
      node.next = next;
      node.prev = first;
      first.next = node;
      next.prev = node;
      size++;
      return true;
    }

    public boolean deleteFront() {
      if (isEmpty()) {
        return false;
      }
      Node first = sentinel;
      Node polled = sentinel.next;
      Node next = polled.next;
      first.next = next;
      next.prev = first;
      size--;
      return true;
    }

    public boolean deleteLast() {
      if (isEmpty()) {
        return false;
      }
      Node polled = sentinel.prev;
      Node first = polled.prev;
      Node next = sentinel;
      first.next = next;
      next.prev = first;
      size--;
      return true;
    }

    public int getFront() {
      if (isEmpty()) {
        return -1;
      }
      return sentinel.next.value;
    }

    public int getRear() {
      if (isEmpty()) {
        return -1;
      }
      return sentinel.prev.value;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public boolean isFull() {
      return size == capacity;
    }

    class Node {
      int value;
      Node prev;
      Node next;

      public Node(int value) {
        this.value = value;
      }
    }
  }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
