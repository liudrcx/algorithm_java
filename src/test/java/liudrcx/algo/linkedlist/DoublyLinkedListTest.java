package liudrcx.algo.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

  @Test
  public void testAddFirst() {
    DoublyLinkedList list = new DoublyLinkedList();
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addFirst(4);
    assertEquals(4, list.size());
    assertIterableEquals(List.of(4, 3, 2, 1), list);
  }

  @Test
  public void testAddLst() {
    DoublyLinkedList list = new DoublyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    assertEquals(4, list.size());
    assertIterableEquals(List.of(1, 2, 3, 4), list);
  }


  @Test
  public void testAdd() {
    DoublyLinkedList list = getLinkedList();

    list.add(0, 5);
    assertIterableEquals(List.of(5, 1, 2, 3, 4), list);

    list = getLinkedList();
    list.add(2, 5);
    assertIterableEquals(List.of(1, 2, 5, 3, 4), list);

    list = getLinkedList();
    list.add(4, 5);
    assertIterableEquals(List.of(1, 2, 3, 4, 5), list);

    assertThrows(IllegalArgumentException.class,
        () -> {
          DoublyLinkedList linkedList = getLinkedList();
          linkedList.add(5, 5);
        });
  }

  @Test
  public void testRemove() {
    DoublyLinkedList list = getLinkedList();
    list.remove(2);
    assertIterableEquals(List.of(1, 2, 4), list);
    assertThrows(IllegalArgumentException.class, () -> list.remove(10));

    DoublyLinkedList list2 = new DoublyLinkedList();
    assertThrows(IllegalArgumentException.class, () -> list2.remove(0));
  }

  @Test
  public void testRemoveFirst() {
    DoublyLinkedList list = getLinkedList();
    list.removeFirst();
    assertIterableEquals(List.of(2, 3, 4), list);
    list.removeFirst();
    assertIterableEquals(List.of(3, 4), list);
    list.removeFirst();
    assertIterableEquals(List.of(4), list);
    list.removeFirst();
    assertIterableEquals(List.of(), list);
    assertThrows(IllegalArgumentException.class, list::removeFirst);
  }

  @Test
  public void testRemoveLast() {
    DoublyLinkedList list = getLinkedList();
    list.removeLast();
    assertIterableEquals(List.of(1, 2, 3), list);
    list.removeLast();
    assertIterableEquals(List.of(1, 2), list);
    list.removeLast();
    assertIterableEquals(List.of(1), list);
    list.removeLast();
    assertIterableEquals(List.of(), list);
    assertThrows(IllegalArgumentException.class, list::removeLast);
  }

  private DoublyLinkedList getLinkedList() {
    DoublyLinkedList list = new DoublyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    return list;
  }
}
