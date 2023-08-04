package liudrcx.algo.binarysearch.leetcode;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class Search_Insert_Position_35 {
  class Solution {
    public int searchInsert(int[] nums, int target) {
      //using left most
      int i = 0, j = nums.length - 1;
      while(i <= j) {
        int m = (i + j) >>> 1;
        if (target <= nums[m]) {
          j = m - 1;
        } else {
          i = m + 1;
        }
      }
      return i;
    }
  }

}
