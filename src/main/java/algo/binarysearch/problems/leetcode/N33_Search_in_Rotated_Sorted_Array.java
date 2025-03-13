package algo.binarysearch.problems.leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class N33_Search_in_Rotated_Sorted_Array {

  class Solution {
    public int search(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
        return -1;
      }

      int i = 0, j = nums.length - 1;
      while(i <= j) {
        int mid = (i + j) >>> 1;

        if (nums[mid] == target) {
          return mid;
        }

        if (nums[i] <= nums[mid]) {
          if (nums[i] <= target && target < nums[mid]) {
            j = mid - 1;
          } else {
            i = mid + 1;
          }
        } else {
          if (nums[mid] < target && target <= nums[j]) {
            i = mid + 1;
          } else {
            j = mid - 1;
          }
        }
      }

      return -1;
    }
  }
}
