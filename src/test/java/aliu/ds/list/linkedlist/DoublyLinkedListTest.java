package aliu.ds.list.linkedlist;

import aliu.ds.list.DsList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoublyLinkedListTest {

  @Test
  public void testAddFirst() {
    DsList<Integer> list = new DoublyLinkedList();
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addFirst(4);
    assertEquals(4, list.size());
    assertIterableEquals(List.of(4, 3, 2, 1), list);
  }

  @Test
  public void testAddLst() {
    DsList<Integer> list = new DoublyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    assertEquals(4, list.size());
    assertIterableEquals(List.of(1, 2, 3, 4), list);
  }


  @Test
  public void testAdd() {
    DsList<Integer> list = getLinkedList();

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
          DsList<Integer> linkedList = getLinkedList();
          linkedList.add(5, 5);
        });
  }

  @Test
  public void testRemove() {
    DsList<Integer> list = getLinkedList();
    list.remove(2);
    assertIterableEquals(List.of(1, 2, 4), list);
    assertThrows(IllegalArgumentException.class, () -> list.remove(10));

    DsList<Integer> list2 = new DoublyLinkedList();
    assertThrows(IllegalArgumentException.class, () -> list2.remove(0));
  }

  @Test
  public void testRemoveFirst() {
    DsList<Integer> list = getLinkedList();
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
    DsList<Integer> list = getLinkedList();
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

  private DsList<Integer> getLinkedList() {
    DsList<Integer> list = new DoublyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    return list;
  }
}
