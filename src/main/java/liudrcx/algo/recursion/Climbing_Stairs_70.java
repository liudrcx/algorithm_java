package liudrcx.algo.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *https://leetcode.com/problems/climbing-stairs/
 */
public class Climbing_Stairs_70 {

  class Solution1 {

    private Map<Integer, Integer> cached = new HashMap<>();

    public int climbStairs(int n) {
      if (cached.containsKey(n)) {
        return cached.get(n);
      }

      if (n == 1) {
        cached.put(1, 1);
        return 1;
      }

      if (n == 2) {
        cached.put(2, 2);
        return 2;
      }

      int result = climbStairs(n - 1) + climbStairs(n - 2);
      cached.put(n, result);
      return result;
    }
  }

}
