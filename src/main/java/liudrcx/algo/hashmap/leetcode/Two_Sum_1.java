package liudrcx.algo.hashmap.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class Two_Sum_1 {

  class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
          return new int[] {map.get(target - nums[i]), i};
        } else {
          map.put(nums[i], i);
        }
      }
      return new int[] {-1, -1};
    }
  }
}
