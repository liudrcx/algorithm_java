package algo.dp;

import org.junit.jupiter.api.Test;

import static algo.dp.Knapsack_0_1_Problem.Item;
import static algo.dp.Knapsack_0_1_Problem.select1;
import static algo.dp.Knapsack_0_1_Problem.select2;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack_0_1_Problem_Test {

  @Test
  public void testSelect1() {
    Item[] items = new Item[]{
      new Item( "黄金", 4, 1600),
      new Item( "宝石", 8, 2400),
      new Item( "白银", 5, 30),
      new Item( "钻石", 1, 10_000)
    };

    int result = select1(items, 10);
    assertEquals(12400, result);
  }

  @Test
  public void testSelect2() {
    Item[] items = new Item[]{
      new Item( "黄金", 4, 1600),
      new Item( "宝石", 8, 2400),
      new Item( "白银", 5, 30),
      new Item( "钻石", 1, 10_000)
    };

    int result = select2(items, 10);
    assertEquals(12400, result);
  }
}
