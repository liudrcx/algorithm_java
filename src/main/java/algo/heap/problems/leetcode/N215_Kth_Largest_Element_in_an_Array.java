package algo.heap.problems.leetcode;

import algo.heap.Heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class N215_Kth_Largest_Element_in_an_Array {

  class Solution {
    public int findKthLargest(int[] nums, int k) {
      Heap<Integer> heap = new Heap<>(k, (a, b) -> a - b);
      for (int i = 0; i < k; i++) {
        heap.offer(nums[i]);
      }

      for(int i = k; i < nums.length; i++) {
        if (nums[i] > heap.peek()) {
          heap.replace(nums[i]);
        }
      }

      return heap.peek();
    }
  }
}
