package liudrcx.algo.binarysearch.leetcode;

/*
* https://leetcode.com/problems/search-in-rotated-sorted-array/description/
* */
public class Search_in_Rotated_Sorted_Array_33 {

  //[4,5,6,7,0,1,2]
  class Solution {
    public int search(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
        return -1;
      }

      int i = 0, j = nums.length - 1;
      while(i <= j) {
        int m = (i + j) >>> 1;
        if (nums[m] == target) {
          return m;
        }

        if (nums[i] <= nums[m]) {
          if (nums[i] <= target && target < nums[m]) {
            j = m - 1;
          } else {
            i = m + 1;
          }
        } else {
          if (nums[m] < target && target <= nums[j]) {
            i = m + 1;
          } else {
            j = m - 1;
          }
        }
      }

      return -1;
    }
  }
}
