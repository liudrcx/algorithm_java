package liudrcx.algo.binarysearch.leetcode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34 {

  class Solution {
    public int[] searchRange(int[] nums, int target) {
      int left = leftMost(nums, target);
      if (left == -1) {
        return new int[] {-1, -1};
      } else {
        return new int[] {left, rightMost(nums, target)};
      }
    }

    private int leftMost(int[] nums, int target) {
      int i = 0, j = nums.length - 1;
      int candidate = -1;
      while(i <= j) {
        int m = (i + j) >>> 1;
        if (target < nums[m]) {
          j = m - 1;
        } else if(target > nums[m]){
          i = m + 1;
        } else {
          candidate = m;
          j = m - 1;
        }
      }
      return candidate;
    }

    private int rightMost(int[] nums, int target)  {
      int i = 0, j = nums.length - 1;
      int candidate = -1;
      while(i <= j) {
        int m = (i + j) >>> 1;
        if (target < nums[m]) {
          j = m - 1;
        } else if (target > nums[m]) {
          i = m + 1;
        } else {
          candidate = m;
          i = m + 1;
        }
      }
      return candidate;
    }
  }
}
