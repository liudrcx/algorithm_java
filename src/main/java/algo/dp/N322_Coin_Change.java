package algo.dp;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/coin-change/description/
 */
public class N322_Coin_Change {

  class Solution1 {
    public int coinChange(int[] coins, int amount) {
      int[][] dp = new int[coins.length][amount + 1];
      for(int j = 1; j < amount + 1; j++) {
        if (j >= coins[0]) {
          dp[0][j] = 1 + dp[0][j - coins[0]];
        } else {
          dp[0][j] = amount + 1;
        }
      }

      for(int i = 1; i < coins.length; i++) {
        for (int j = 1; j < amount + 1; j++) {
          if (j >= coins[i]) {
            dp[i][j] = Integer.min(dp[i - 1][j], 1 + dp[i][j - coins[i]]);
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        }
      }

      int x = dp[coins.length - 1][amount];
      return x < amount + 1 ? x : -1;
    }
  }

  class Solution2 {
    public int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, amount + 1);
      dp[0] = 0;

      for(int i = 0; i < coins.length; i++) {
        for (int j = 0; j < amount + 1; j++) {
          if (j >= coins[i]) {
            dp[j] = Integer.min(dp[j], 1 + dp[j - coins[i]]);
          }
        }
      }

      return dp[amount] < amount + 1 ? dp[amount] : -1;
    }
  }
}
