package algo.greedy;

/**
 * https://leetcode.com/problems/coin-change-ii/description/
 */
public class N518_Coin_Change_II {

  public static class Solution1 {
    public int change(int amount, int[] coins) {
      return _change(0, coins, amount);
    }

    private int _change(int index, int[] coins, int remain) {
      if (remain == 0) {
        return 1;
      } else if (remain < 0) {
        return 0;
      } else {
        int count = 0;
        for (int i = index; i < coins.length; i++) {
          count += _change(i, coins, remain -coins[i]);
        }
        return count;
      }
    }
  }
}
