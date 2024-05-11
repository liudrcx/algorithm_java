package liudrcx.ds.list.array;

import liudrcx.ds.list.DsList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DynamicArrayTest {

  @Test
  public void testAdd() {
    DsList<Integer> dynamicArray = new DynamicArray();
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);
    dynamicArray.add(2, 5);
    dynamicArray.addFirst(6);

    assertIterableEquals(List.of(6, 1, 2, 5, 3, 4), dynamicArray);
    assertEquals(6, dynamicArray.size());
  }

  @Test
  public void testGrowArray() {
    DsList<Integer> dynamicArray = new DynamicArray(3);
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);

    assertIterableEquals(List.of(1, 2, 3, 4), dynamicArray);
    assertEquals(4, dynamicArray.size());
  }

  @Test
  public void testRemove() {
    DsList<Integer> dynamicArray = new DynamicArray(3);
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);

    //1, 2, 4
    dynamicArray.remove(2);

    assertIterableEquals(List.of(1, 2, 4), dynamicArray);
    assertEquals(3, dynamicArray.size());
  }

  @Test
  public void testRemoveFirst() {
    DsList<Integer> dynamicArray = new DynamicArray(3);
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);

    //2, 3, 4
    dynamicArray.removeFirst();


    assertIterableEquals(List.of(2, 3, 4), dynamicArray);
    assertEquals(3, dynamicArray.size());
  }

  @Test
  public void testRemoveLast() {
    DsList<Integer> dynamicArray = new DynamicArray(3);
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);

    //1, 2, 3
    dynamicArray.removeLast();

    assertIterableEquals(List.of(1, 2, 3), dynamicArray);
    assertEquals(3, dynamicArray.size());
  }
}
