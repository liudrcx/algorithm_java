package liudrcx.algo.recursion.leetcode;

import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *https://leetcode.com/problems/climbing-stairs/
 */
public class Climbing_Stairs_70 {

  static class Solution {
    public int climbStairs(int n) {
      int[] cached = new int[n + 1];
      Arrays.fill(cached, -1);
      return climbStairs(n, cached);
    }

    private int climbStairs(int n, int[] cached) {
      if (n == 1) {
        return 1;
      }

      if (n == 2) {
        return 2;
      }

      if (cached[n] != -1) {
        return cached[n];
      }

      int result = climbStairs(n - 1, cached) + climbStairs(n - 2, cached);
      cached[n] = result;
      return result;
    }
  }

  public static void main(String[] args){
    int result = new Solution().climbStairs(2);
    assertThat(result).isEqualTo(2);

    result = new Solution().climbStairs(1);
    assertThat(result).isEqualTo(1);
  }

}
