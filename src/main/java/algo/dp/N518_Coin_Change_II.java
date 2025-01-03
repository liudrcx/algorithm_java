package algo.dp;

/**
 * https://leetcode.com/problems/coin-change-ii/description/
 */
public class N518_Coin_Change_II {

  public static class Solution1 {
    public int change(int amount, int[] coins) {
      int[][] dp = new int[coins.length][amount + 1];

      for (int i = 0; i < coins.length; i++) {
        dp[i][0] = 1;
      }

      for (int j = 1; j < amount + 1; j++) {
        if (j >= coins[0]) {
          dp[0][j] = dp[0][j - coins[0]];
        }
      }

      for (int i = 1; i < coins.length; i++) {
        for (int j = 1; j < amount + 1; j++) {
          if (j >= coins[i]) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        }
      }

      return dp[coins.length - 1][amount];
    }
  }

  public static class Solution2 {
    public int change(int amount, int[] coins) {
      int[] dp = new int[amount + 1];
      dp[0] = 1;

      for (int i = 0; i < coins.length; i++) {
        for (int j = coins[i]; j < amount + 1; j++) {
          dp[j] += dp[j - coins[i]];
        }
      }

      return dp[amount];
    }
  }
}
