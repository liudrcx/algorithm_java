package liudrcx.algo.hashtable.problems;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/single-number/description/
 * <p>
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: 1
 */
public class Single_Number_136 {

  class Solution1 {
    public int singleNumber(int[] nums) {
      HashSet<Integer> numSet = new HashSet<>();
      for (int num : nums) {
        if (!numSet.add(num)) {
          numSet.remove(num);
        }
      }
      return numSet.toArray(new Integer[0])[0];
    }
  }

  class Solution2 {
    public int singleNumber(int[] nums) {
      int result = nums[0];
      for (int i = 1; i < nums.length; i++) {
        result ^= nums[i];
      }
      return result;
    }
  }

}
