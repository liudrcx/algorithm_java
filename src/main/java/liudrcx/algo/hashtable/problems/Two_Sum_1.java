package liudrcx.algo.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class Two_Sum_1 {

  class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> numMap = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int v = target - nums[i];
        if (numMap.containsKey(v)) {
          return new int[] {numMap.get(v), i};
        } else {
          numMap.put(nums[i], i);
        }
      }
      return new int[]{};
    }
  }
}
