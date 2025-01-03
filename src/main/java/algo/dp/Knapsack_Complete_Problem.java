package algo.dp;

public class Knapsack_Complete_Problem {

  public static int select1(Item[] items, int total) {
    int[][] dp = new int[items.length][total + 1];
    for (int j = 0; j < total + 1; j++) {
      Item item0 = items[0];
      if (j >= item0.weight) {
        dp[0][j] = item0.value + dp[0][j - item0.weight];
      }
    }

    for (int i = 1; i < items.length; i++) {
      Item item = items[i];
      for (int j = 1; j < total + 1; j++) {
        if (j >= item.weight) {
          dp[i][j] = Integer.max(dp[i - 1][j], item.value + dp[i][j - item.weight]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[items.length - 1][total];
  }

  public static int select2(Item[] items, int total) {
    int[] dp = new int[total + 1];
    for (int i = 0; i < items.length; i++) {
      Item item = items[i];
      for (int j = 0; j < total + 1; j++) {
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
