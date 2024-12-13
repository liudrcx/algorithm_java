package algo.greedy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/coin-change/description/
 */
public class N322_Coin_Change {

  public static class Solution1 {
    public int coinChange(int[] coins, int amount) {
      conChange(0, coins, amount, new AtomicInteger(-1));
      return min;
    }

    private int min = -1;

    private void conChange(int index, int[] coins, int remain, AtomicInteger count) {
      count.incrementAndGet();

      if (remain == 0) {
        if (min == -1) {
          min = count.get();
        } else {
          min = Integer.min(min, count.get());
        }
      } else if (remain > 0) {
        for (int i = index; i < coins.length; i++) {
          conChange(i, coins, remain - coins[i], count);
        }
      }

      count.decrementAndGet();
    }
  }
}
