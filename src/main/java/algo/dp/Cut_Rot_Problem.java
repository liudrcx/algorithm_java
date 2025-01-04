package algo.dp;

public class Cut_Rot_Problem {

  /**
   * @param values index of array represents number of rot, value of array represents value of rot
   * @param total
   * @return
   */
  public static int cut1(int[] values, int total) {
    int[][] dp = new int[values.length][total + 1];
    for (int i = 1; i < values.length; i++) {
      for (int j = 1; j < total + 1; j++) {
        if (j >= i) {
          dp[i][j] = Integer.max(dp[i - 1][j], values[i] + dp[i][j - i]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[values.length - 1][total];
  }

  public static int cut2(int[] values, int total) {
    int[] dp = new int[total + 1];

    for (int i = 1; i < values.length; i++) {
      for (int j = 1; j < total + 1; j++) {
        if (j >= i) {
          dp[j] = Integer.max(dp[j], values[i] + dp[j - i]);
        }
      }
    }

    return dp[total];
  }
}
