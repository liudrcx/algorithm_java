package algo.hashtable.problems.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class N217_Contains_Duplicate {

  class Solution {
    public boolean containsDuplicate(int[] nums) {
      Set<Integer> iSet = new HashSet<>();
      for (int num : nums) {
        if (!iSet.add(num)) {
          return true;
        }
      }
      return false;
    }
  }
}
