package aliu.problems.ds.array;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 */
public class Find_the_Duplicate_Number_287 {

  class Solution1 {

    /**
     *
     *The key idea of this approach is to use the Floyd's Cycle-Finding Algorithm (also known as the "tortoise and hare" algorithm) to detect the cycle in the linked list formed by the nums array.
     *
     * Here's the step-by-step algorithm:
     *
     * 1. Initialize two pointers, slow and fast, both starting at index 0.
     * 2. Move the slow pointer one step at a time, and the fast pointer two steps at a time.
     * 3. When the slow and fast pointers meet, it means there is a cycle in the linked list.
     * 4. Reset the slow pointer to index 0, and keep the fast pointer at the position where it met the slow pointer.
     * 5. Move both slow and fast pointers one step at a time until they meet again.
     * 6. The node where they meet is the start of the cycle, which is the duplicate number.
     */
    public int findDuplicate(int[] nums) {
      int slow = nums[0], fast = nums[0];
      do {
        slow = nums[slow];
        fast = nums[nums[fast]];
      } while (slow != fast);

      slow = nums[0];
      while(slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
      }

      return slow;
    }
  }
}
