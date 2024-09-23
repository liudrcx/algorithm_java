package algoritm.list;

import algorithm.list.DynamicArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicArrayTest {

  @Test
  public void testAdd() {
    DynamicArray list = new DynamicArray();
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
  public void testAddGrow() {
    DynamicArray list = new DynamicArray(3);
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);
    list.add(0, 4);

    assertIterableEquals(List.of(4, 1, 2, 3), list);
    assertEquals(4, list.size());
  }

  @Test
  public void testInvalidIndexAdd() {
    DynamicArray list = new DynamicArray();
    list.add(0, 1);

    assertThrows(IllegalArgumentException.class, () -> list.add(-1, 10));
    assertThrows(IllegalArgumentException.class, () -> list.add(2, 2));
  }

  @Test
  public void testAddFirst() {
    DynamicArray list = new DynamicArray();
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addFirst(4);

    assertIterableEquals(List.of(4, 3, 2, 1), list);
    assertEquals(4, list.size());
  }

  @Test
  public void testAddLast() {
    DynamicArray list = new DynamicArray();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertIterableEquals(List.of(1, 2, 3, 4), list);
    assertEquals(4, list.size());
  }

  @Test
  public void testRemove() {
    DynamicArray<Integer> list = new DynamicArray();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertEquals(3, list.remove(2));
    assertIterableEquals(List.of(1, 2, 4), list);
    assertEquals(3, list.size());
  }

  @Test
  public void testRemoveLast() {
    DynamicArray<Integer> list = new DynamicArray();
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
    DynamicArray<Integer> list = new DynamicArray();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);

    assertEquals(1, list.removeFirst());
    assertIterableEquals(List.of(2, 3, 4), list);
    assertEquals(3, list.size());
  }
}
