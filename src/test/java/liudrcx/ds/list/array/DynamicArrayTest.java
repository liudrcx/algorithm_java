package liudrcx.ds.list.array;

import liudrcx.ds.list.DsList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DynamicArrayTest {

  @Test
  public void testAdd() {
    DsList<Integer> dynamicArray = new DynamicArray<Integer>(3);
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);
    dynamicArray.add(2, 5);
    dynamicArray.addFirst(6);

    assertEquals(6, dynamicArray.size());
    assertIterableEquals(List.of(6, 1, 2, 5, 3, 4), dynamicArray);
  }

  @Test
  public void testRemove() {
    DsList<Integer> dynamicArray = new DynamicArray(3);
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);

    dynamicArray.remove(2);

    assertEquals(3, dynamicArray.size());
    assertIterableEquals(List.of(1, 2, 4), dynamicArray);
  }
}
