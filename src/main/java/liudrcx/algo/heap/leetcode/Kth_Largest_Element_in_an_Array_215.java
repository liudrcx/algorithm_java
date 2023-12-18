package liudrcx.algo.heap.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class Kth_Largest_Element_in_an_Array_215 {

  class Solution1 {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o));
      for (int i = 0; i < k; i++) {
        queue.offer(nums[i]);
      }

      for (int i = k; i < nums.length; i++) {
        if (queue.peek() < nums[i]) {
          queue.poll();
          queue.offer(nums[i]);
        }
      }

      return queue.peek();
    }
  }
}
