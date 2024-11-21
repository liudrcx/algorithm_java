package algo.binarysearch.problems.leetcode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class N34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

  class Solution {
    public int[] searchRange(int[] nums, int target) {
      int left = leftMost(nums, target);
      if (left == -1) {
        return new int[] {-1, -1};
      }
      return new int[] {left, rightMost(nums,target)};
    }

    private int leftMost(int[] nums, int target) {
      int i = 0, j = nums.length - 1;
      int result = -1;
      while (i <= j) {
        int m = (i + j) >>> 1;
        if (target < nums[m]) {
          j = m - 1;
        } else if (target > nums[m]){
          i = m + 1;
        } else {
          result = m;
          j = m - 1;
        }
      }
      return result;
    }

    private int rightMost(int[] nums, int target) {
      int i = 0, j = nums.length - 1;
      int result = -1;
      while (i <= j) {
        int m = (i + j) >>> 1;
        if (target < nums[m]) {
          j = m - 1;
        } else if (target > nums[m]){
          i = m + 1;
        } else {
          result = m;
          i = m + 1;
        }
      }
      return result;
    }
  }
}
