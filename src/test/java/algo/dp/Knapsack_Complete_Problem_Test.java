package algo.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static algo.dp.Knapsack_Complete_Problem.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack_Complete_Problem_Test {

  @Test
  public void testSelect1() {
    Item[] items = new Item[] {
      new Item("青铜", 2, 3),
      new Item("白银", 3, 4),
      new Item("黄金", 4, 7)
    };

    int result = select1(items, 6);
    assertEquals(10, result);
  }

  @Test
  public void testSelect2() {
    Item[] items = new Item[] {
      new Item("青铜", 2, 3),
      new Item("白银", 3, 4),
      new Item("黄金", 4, 7)
    };

    int result = select2(items, 6);
    assertEquals(10, result);
  }
}
