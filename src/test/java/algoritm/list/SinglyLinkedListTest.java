package algoritm.list;

import algorithm.list.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinglyLinkedListTest {

  @Test
  public void testAdd() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList();
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
    SinglyLinkedList<Integer> list = new SinglyLinkedList();
    list.add(0, 1);

    assertThrows(IllegalArgumentException.class, () -> list.add(-1, 10));
    assertThrows(IllegalArgumentException.class, () -> list.add(2, 2));
  }

  @Test
  public void testAddFirst() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList();
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addFirst(4);

    assertIterableEquals(List.of(4, 3, 2, 1), list);
    assertEquals(4, list.size());
  }

  @Test
  public void testAddLast() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertIterableEquals(List.of(1, 2, 3, 4), list);
    assertEquals(4, list.size());
  }

  @Test
  public void testRemove() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList();
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
    SinglyLinkedList<Integer> list = new SinglyLinkedList();
    list.add(0, 1);

    assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
    assertThrows(IllegalArgumentException.class, () -> list.remove(1));
  }

  @Test
  public void testRemoveLast() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList();
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
    SinglyLinkedList<Integer> list = new SinglyLinkedList();
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
    SinglyLinkedList<Integer> list = new SinglyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertEquals(3, list.get(2));

    assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
    assertThrows(IllegalArgumentException.class, () -> list.remove(4));
  }
}
