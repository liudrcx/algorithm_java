package liudrcx.algo.hashmap.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/description/
 */
public class Contains_Duplicate_217 {
  class Solution {
    public boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
        if (set.contains(num)) {
          return true;
        } else {
          set.add(num);
        }
      }
      return false;
    }
  }
}
