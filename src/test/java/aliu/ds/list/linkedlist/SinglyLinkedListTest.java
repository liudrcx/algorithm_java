package aliu.ds.list.linkedlist;

import aliu.ds.list.DsList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinglyLinkedListTest {

  @Test
  public void testAddFirst() {
    DsList<Integer> list = new SinglyLinkedList();
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addFirst(4);

    assertEquals(4, list.size());
    assertIterableEquals(List.of(4, 3, 2, 1), list);
  }

  @Test
  public void testAddLast() {
    DsList<Integer> list = getLinkedList();

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
    DsList<Integer> list1 = getLinkedList();
    list1.remove(2);
    assertIterableEquals(List.of(1, 2, 4), list1);


    DsList<Integer> list2 = getLinkedList();
    list2.remove(0);
    assertIterableEquals(List.of(2, 3, 4), list2);

    DsList<Integer> list3 = getLinkedList();
    assertThrows(IllegalArgumentException.class, () -> list3.remove(5));

    DsList<Integer> list4 = getLinkedList();
    assertThrows(IllegalArgumentException.class, () -> list4.remove(4));
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
    assertThrows(IllegalArgumentException.class, list::removeFirst);
  }

  private  DsList<Integer> getLinkedList() {
    DsList<Integer> list = new SinglyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    return list;
  }
}
