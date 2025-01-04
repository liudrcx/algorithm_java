package algo.hashtable.problems.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number/
 */
public class N136_Single_Number {

  class Solution1 {
    public int singleNumber(int[] nums) {
      Set<Integer> iSet = new HashSet<>();
      for (int num : nums) {
        if (!iSet.add(num)) {
          iSet.remove(num);
        }
      }
      return iSet.toArray(new Integer[0])[0];
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
