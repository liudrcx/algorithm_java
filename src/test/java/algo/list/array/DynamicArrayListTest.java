package algo.list.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicArrayListTest {

  @Test
  public void testAdd() {
    DynamicArrayList<Integer> list = new DynamicArrayList<>(2);
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
    DynamicArrayList<Integer> list = new DynamicArrayList<>(2);
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
    DynamicArrayList<Integer> list = new DynamicArrayList<>(2);
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
  public void testGet() {
    DynamicArrayList<Integer> list = new DynamicArrayList<>(new Integer[] {1, 2});

    assertThrowsExactly(IllegalArgumentException.class, () -> list.get(2));
    assertEquals(1, list.get(0));
  }

  @Test
  public void testRemove() {
    DynamicArrayList<Integer> list = new DynamicArrayList<>(new Integer[] {1, 2, 3, 4});

    assertThrowsExactly(IllegalArgumentException.class, () -> list.remove(6));
    assertEquals(3, list.remove(2));
    assertFalse(list.isEmpty());
    assertFalse(list.isFull());
    assertEquals(3, list.size());
  }

  @Test
  public void testRemoveFirst() {
    DynamicArrayList<Integer> list = new DynamicArrayList<>(new Integer[] {1, 2, 3, 4});

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
    DynamicArrayList<Integer> list = new DynamicArrayList<>(new Integer[] {1, 2, 3, 4});

    assertEquals(4, list.removeLast());
    assertEquals(3, list.removeLast());
    assertEquals(2, list.removeLast());
    assertEquals(1, list.removeLast());
    assertThrowsExactly(IllegalArgumentException.class, () -> list.removeLast());

    assertTrue(list.isEmpty());
    assertFalse(list.isFull());
    assertEquals(0, list.size());
  }

  @Test
  public void testIsEmpty() {
    DynamicArrayList<Integer> list = new DynamicArrayList<>();
    assertTrue(list.isEmpty());

    list = new DynamicArrayList<>(new Integer[]{1, 2});
    assertFalse(list.isEmpty());
  }

  @Test
  public void testIsFull() {
    DynamicArrayList<Integer> list = new DynamicArrayList<>();
    assertFalse(list.isFull());

    list = new DynamicArrayList<>(new Integer[]{1, 2});
    assertFalse(list.isFull());
  }
}
