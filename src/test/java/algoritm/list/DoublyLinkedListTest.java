package algoritm.list;

import algorithm.list.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoublyLinkedListTest {

  @Test
  public void testAdd() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);
    list.add(3, 4);
    list.add(2, 5);
    list.add(0, 6);

    assertIterableEquals(List.of(6, 1, 2, 5, 3, 4), list);
    assertEquals(6, list.size());
  }

  @Test
  public void testInvalidIndexAdd() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList();
    list.add(0, 1);

    assertThrows(IllegalArgumentException.class, () -> list.add(-1, 10));
    assertThrows(IllegalArgumentException.class, () -> list.add(2, 2));
  }

  @Test
  public void testAddFirst() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList();
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addFirst(4);

    assertIterableEquals(List.of(4, 3, 2, 1), list);
    assertEquals(4, list.size());
  }

  @Test
  public void testAddLast() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertIterableEquals(List.of(1, 2, 3, 4), list);
    assertEquals(4, list.size());
  }

  @Test
  public void testRemove() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertEquals(3, list.remove(2));
    assertIterableEquals(List.of(1, 2, 4), list);
    assertEquals(3, list.size());
  }

  @Test
  public void testInvalidIndexRemove() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList();
    list.add(0, 1);

    assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
    assertThrows(IllegalArgumentException.class, () -> list.remove(1));
  }

  @Test
  public void testRemoveLast() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertEquals(4,list.removeLast());
    assertIterableEquals(List.of(1, 2, 3), list);
    assertEquals(3, list.size());
  }

  @Test
  public void testRemoveFirst() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertEquals(1, list.removeFirst());
    assertIterableEquals(List.of(2, 3, 4), list);
    assertEquals(3, list.size());
  }

  @Test
  public void testGet() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertEquals(3, list.get(2));

    assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
    assertThrows(IllegalArgumentException.class, () -> list.remove(4));
  }
}
