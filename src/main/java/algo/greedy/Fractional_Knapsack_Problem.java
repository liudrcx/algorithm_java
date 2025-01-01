package algo.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * 1. n个物品都是液体，有重量和价值
 *     2. 现在你要取走 10升 的液体
 *     3. 每次可以不拿，全拿，或拿一部分，问最高价值是多少
 *
 *         编号 重量(升) 价值
 *         0   4       24      水
 *         1   8       160     牛奶       选中 7/8
 *         2   2       4000    五粮液     选中
 *         3   6       108     可乐
 *         4   1       4000    茅台       选中
 *
 *         8140
 *
 *         简化起见，给出的数据都是【价值/重量】能够整除，避免计算结果中出现小数，增加心算难度
 *
 */
public class Fractional_Knapsack_Problem {

  public static int select(List<Item> items, int total) {
    Collections.sort(items, Comparator.comparingInt(Item::unitValue).reversed());
    int result = 0;
    int remain = total;
    for (Item item : items) {
      if (remain >= item.weight) {
        result += item.value;
        remain -= item.weight;
      } else {
        result += (remain * item.unitValue());
        break;
      }
    }
    return result;
  }

  public static class Item {

    private int index;

    private int weight;

    private int value;


    public Item(int index, int weight, int value) {
      this.index = index;
      this.weight = weight;
      this.value = value;
    }

    public int unitValue() {
      return value / weight;
    }

    public int getIndex() {
      return index;
    }

    public int getWeight() {
      return weight;
    }

    public int getValue() {
      return value;
    }
  }
}
