package liudrcx.algo.heap.leetcode;

import liudrcx.algo.heap.MinHeap;

/**
 *https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class Kth_Largest_Element_in_a_Stream_703 {

  class KthLargest {

    private MinHeap<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
      minHeap = new MinHeap<>(k);

      for(int i = 0; i < nums.length; i++) {
        add(nums[i]);
      }
    }

    public int add(int val) {
      if (!minHeap.isFull()) {
        minHeap.offer(val);
      } else {
        if (minHeap.peek().compareTo(val) < 0) {
          minHeap.replace(val);
        }
      }

      return minHeap.peek();
    }
  }
}
