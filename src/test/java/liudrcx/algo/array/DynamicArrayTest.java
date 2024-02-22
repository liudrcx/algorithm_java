package liudrcx.algo.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicArrayTest {

  @Test
  public void testAdd() {
    DynamicArray dynamicArray = new DynamicArray();
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);
    dynamicArray.add(2, 5);
    dynamicArray.addFirst(6);

    //6, 1, 2, 5, 3, 4
    assertThat(dynamicArray.stream())
        .hasSameElementsAs(List.of(6, 1, 2, 5, 3, 4));

    assertThat(dynamicArray.size()).isEqualTo(6);
  }

  @Test
  public void testGrowArray() {
    DynamicArray dynamicArray = new DynamicArray(3);
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);

    assertThat(dynamicArray.stream())
        .hasSameElementsAs(List.of(1, 2, 3, 4));

    assertThat(dynamicArray.size()).isEqualTo(4);
  }

  @Test
  public void testRemove() {
    DynamicArray dynamicArray = new DynamicArray(3);
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);

    //1, 2, 4
    dynamicArray.remove(2);

    assertThat(dynamicArray.stream())
        .hasSameElementsAs(List.of(1, 2, 4));

    assertThat(dynamicArray.size()).isEqualTo(3);
  }

  @Test
  public void testRemoveFirst() {
    DynamicArray dynamicArray = new DynamicArray(3);
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);

    //2, 3, 4
    dynamicArray.removeFirst();

    assertThat(dynamicArray.stream())
      .hasSameElementsAs(List.of(2, 3, 4));

    assertThat(dynamicArray.size()).isEqualTo(3);
  }

  @Test
  public void testRemoveLast() {
    DynamicArray dynamicArray = new DynamicArray(3);
    dynamicArray.addLast(1);
    dynamicArray.addLast(2);
    dynamicArray.addLast(3);
    dynamicArray.addLast(4);

    //1, 2, 3
    dynamicArray.removeLast();

    assertThat(dynamicArray.stream())
      .hasSameElementsAs(List.of(1, 2, 3));

    assertThat(dynamicArray.size()).isEqualTo(3);
  }
}
