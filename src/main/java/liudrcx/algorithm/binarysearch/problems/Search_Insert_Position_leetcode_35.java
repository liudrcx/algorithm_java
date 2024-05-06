package liudrcx.algorithm.binarysearch.problems;

/**
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * nums contains distinct values sorted in ascending order.
 */
public class Search_Insert_Position_leetcode_35 {

  class Solution {
    public int searchInsert(int[] nums, int target) {
      int i = 0, j = nums.length - 1;
      while(i <= j) {
        int m = (i + j) >>> 1;
        if (target < nums[m]) {
          j = m - 1;
        } else if (nums[m] < target) {
          i = m + 1;
        } else {
          return m;
        }
      }
      return i;
    }
  }
}
