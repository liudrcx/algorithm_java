package algo.binarysearch.problems.leetcode;

/**
 * https://leetcode.com/problems/binary-search/description/
 */
public class N704_Binary_Search {

  class Solution {
    public int search(int[] nums, int target) {
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
      return -1;
    }
  }
}
