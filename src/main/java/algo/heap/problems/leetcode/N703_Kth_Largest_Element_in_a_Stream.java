package algo.heap.problems.leetcode;

import algo.heap.Heap;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 */
public class N703_Kth_Largest_Element_in_a_Stream {

  class KthLargest {

    Heap<Integer> heap;

    public KthLargest(int k, int[] nums) {
      heap = new Heap<>(k, (a, b) -> a - b);
      for(int num : nums) {
        add(num);
      }
    }

    public int add(int val) {
      if (!heap.isFull()) {
        heap.offer(val);
      } else {
        if (val > heap.peek()) {
          heap.replace(val);
        }
      }
      return heap.peek();
    }
  }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
