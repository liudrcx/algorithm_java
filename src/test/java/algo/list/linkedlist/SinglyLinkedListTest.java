package algo.list.linkedlist;

import algo.list.array.DynamicArrayList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SinglyLinkedListTest {

  @Test
  public void testGet() {
    SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
    assertThrows(IllegalArgumentException.class,() -> list1.get(0));

    SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>(new Integer[] {1, 2, 3});
    assertThrows(IllegalArgumentException.class,() -> list2.get(-1));
    assertEquals(1, list2.get(0));
    assertEquals(2, list2.get(1));
    assertEquals(3, list2.get(2));
    assertThrows(IllegalArgumentException.class,() -> list2.get(3));
  }

  @Test
  public void testIsEmpty() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    assertTrue(list.isEmpty());

    list = new SinglyLinkedList<>(new Integer[]{1, 2});
    assertFalse(list.isEmpty());
  }

  @Test
  public void testIsFull() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    assertFalse(list.isFull());

    list = new SinglyLinkedList<>(new Integer[]{1, 2});
    assertFalse(list.isFull());
  }

  @Test
  public void testGetSize() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    assertEquals(0, list.size());

    list = new SinglyLinkedList<>(new Integer[]{1, 2});
    assertEquals(2, list.size());
  }

  @Test
  public void testAdd() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);
    list.add(1, 4);

    assertThrowsExactly(IllegalArgumentException.class, () -> list.add(6, 6));

    assertFalse(list.isEmpty());
    assertFalse(list.isFull());
    assertEquals(4, list.size());
    assertIterableEquals(List.of(1, 4, 2, 3), list);
  }

  @Test
  public void testAddFirst() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addFirst(4);

    assertFalse(list.isEmpty());
    assertFalse(list.isFull());
    assertEquals(4, list.size());
    assertIterableEquals(List.of(4, 3, 2, 1), list);
  }

  @Test
  public void testAddLast() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertFalse(list.isEmpty());
    assertFalse(list.isFull());
    assertEquals(4, list.size());
    assertIterableEquals(List.of(1, 2, 3, 4), list);
  }

  @Test
  public void testRemove() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>(new Integer[] {1, 2, 3, 4});

    assertThrowsExactly(IllegalArgumentException.class, () -> list.remove(6));
    assertEquals(3, list.remove(2));
    assertFalse(list.isEmpty());
    assertFalse(list.isFull());
    assertEquals(3, list.size());
  }

  @Test
  public void testRemoveFirst() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>(new Integer[] {1, 2, 3, 4});

    assertEquals(1, list.removeFirst());
    assertEquals(2, list.removeFirst());
    assertEquals(3, list.removeFirst());
    assertEquals(4, list.removeFirst());
    assertThrowsExactly(IllegalArgumentException.class, () -> list.removeFirst());

    assertTrue(list.isEmpty());
    assertFalse(list.isFull());
    assertEquals(0, list.size());
  }

  @Test
  public void testRemoveLast() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>(new Integer[] {1, 2, 3, 4});

    assertEquals(4, list.removeLast());
    assertEquals(3, list.removeLast());
    assertEquals(2, list.removeLast());
    assertEquals(1, list.removeLast());
    assertThrowsExactly(IllegalArgumentException.class, () -> list.removeLast());

    assertTrue(list.isEmpty());
    assertFalse(list.isFull());
    assertEquals(0, list.size());
  }
}
