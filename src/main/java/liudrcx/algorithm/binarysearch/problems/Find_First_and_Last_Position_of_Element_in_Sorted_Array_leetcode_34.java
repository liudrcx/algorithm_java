package liudrcx.algorithm.binarysearch.problems;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * nums is a non-decreasing array.
 *
 */
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_leetcode_34 {

  class Solution {
    public int[] searchRange(int[] nums, int target) {
      int leftMost = leftMost(nums, target);
      if (leftMost == -1) {
        return new int[] {-1, -1};
      }
      return new int[] {leftMost, rightMost(nums, target)};
    }

    private int leftMost(int[] nums, int target) {
      int i = 0, j = nums.length - 1;
      int result = -1;

      while(i <= j) {
        int m = (i + j) >>> 1;
        if (target < nums[m]) {
          j = m - 1;
        } else if (nums[m] < target) {
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

      while(i <= j) {
        int m = (i + j) >>> 1;
        if (target < nums[m]) {
          j = m - 1;
        } else if (nums[m] < target) {
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
