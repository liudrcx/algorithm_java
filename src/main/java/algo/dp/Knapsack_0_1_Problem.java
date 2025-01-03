package algo.dp;

public class Knapsack_0_1_Problem {

   /*
        1. n个物品都是固体，有重量和价值
        2. 现在你要取走不超过 10克 的物品
        3. 每次可以不拿或全拿，问最高价值是多少

            编号 重量(g)  价值(元)
            0   4       1600           黄金一块   400
            1   8       2400           红宝石一粒 300
            2   5       30             白银一块
            3   1       10000          钻石一粒

        12400
     */
  public static int select1(Item[] items, int total) {
    int[][] dp = new int[items.length][total + 1];
    for (int j = 0; j < total + 1; j++) {
      if (j >= items[0].weight) {
        dp[0][j] = items[0].value;
      }
    }

    for (int i = 1; i < items.length; i++) {
      Item item = items[i];
      for (int j = 1; j < total + 1; j++) {
        if (j >= item.weight) {
          dp[i][j] = Integer.max(dp[i - 1][j], item.value + dp[i - 1][j - item.weight]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[items.length - 1][total];
  }

  public static int select2(Item[] items, int total) {
    int[] dp = new int[total + 1];
    for (int j = 0; j < total + 1; j++) {
      if (j >= items[0].weight) {
        dp[j] = items[0].value;
      }
    }

    for (int i = 1; i < items.length; i++) {
      Item item = items[i];
      for (int j = total; j >= 0; j--) {
        if (j >= item.weight) {
          dp[j] = Integer.max(dp[j], item.value + dp[j - item.weight]);
        }
      }
    }

    return dp[total];
  }

  public static class Item {

    private String name;

    private int weight;

    private int value;

    public Item(String name, int weight, int value) {
      this.name = name;
      this.weight = weight;
      this.value = value;
    }

    public String getName() {
      return name;
    }

    public int getWeight() {
      return weight;
    }

    public int getValue() {
      return value;
    }
  }

}
