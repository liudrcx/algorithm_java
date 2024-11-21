package algo.binarysearch.problems.leetcode;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class N35_Search_Insert_Position {

  class Solution {
    public int searchInsert(int[] nums, int target) {
      int i = 0, j = nums.length - 1;
      while(i <= j) {
        int m = (i + j) >>> 1;
        if (target < nums[m]) {
          j = m - 1;
        } else if (target > nums[m]) {
          i = m + 1;
        } else {
          return m;
        }
      }
      return i;
    }
  }
}
