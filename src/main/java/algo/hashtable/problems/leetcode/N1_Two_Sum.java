package algo.hashtable.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class N1_Two_Sum {

  class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int x = nums[i];
        int y = target - x;
        if (map.containsKey(y)) {
          return new int[] {i, map.get(y)};
        } else {
          map.put(x, i);
        }
      }
      return null;
    }
  }
}
