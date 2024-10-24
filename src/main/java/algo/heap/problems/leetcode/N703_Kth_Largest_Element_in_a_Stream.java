package algo.heap.problems.leetcode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 */
public class N703_Kth_Largest_Element_in_a_Stream {

  class KthLargest {

    MinHeap heap;

    public KthLargest(int k, int[] nums) {
      heap = new MinHeap(k);
      for (int i = 0; i < nums.length; i++) {
        add(nums[i]);
      }
    }

    public int add(int val) {
      if (!heap.isFull()) {
        heap.offer(val);
      } else {
        if (heap.peek() < val) {
          heap.replace(val);
        }
      }
      return heap.peek();
    }

    static class MinHeap {

      int[] data;

      int size = 0;

      public MinHeap(int[] data) {
        this.data = data;
        this.size = data.length;
        heapify();
      }

      public MinHeap(int capacity) {
        data = new int[capacity];
        size = 0;
      }

      private void heapify() {
        for (int i = (size >> 1) - 1; i >= 0; i--) {
          down(i);
        }
      }

      public int peek() {
        return data[0];
      }

      public boolean isFull() {
        return size == data.length;
      }

      public boolean offer(int e) {
        if (isFull()) {
          return false;
        }
        up(e);
        size++;
        return true;
      }

      private void up(int e) {
        int childIndex = size;
        while(childIndex > 0) {
          int parentIndex = (childIndex - 1) >> 1;
          if (data[parentIndex] > e) {
            data[childIndex] = data[parentIndex];
            childIndex = parentIndex;
          } else {
            break;
          }
        }
        data[childIndex] = e;
      }

      public void replace(int e) {
        data[0] = e;
        down(0);
      }

      private void down(int index) {
        int leftIndex = (index << 1) + 1;
        int rightIndex = leftIndex + 1;

        int minIndex = index;
        if (leftIndex < size && data[leftIndex] < data[minIndex]) {
          minIndex = leftIndex;
        }

        if (rightIndex < size && data[rightIndex] < data[minIndex]) {
          minIndex = rightIndex;
        }

        if (minIndex != index) {
          swap(minIndex, index);
          down(minIndex);
        }
      }

      private void swap(int leftIndex, int rightIndex) {
        int t = data[leftIndex];
        data[leftIndex] = data[rightIndex];
        data[rightIndex] = t;
      }

    }
  }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 *
 * Input:
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 *
 * Output: [null, 4, 5, 5, 8, 8]
 *
 * Explanation:
 *
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3); // return 4
 * kthLargest.add(5); // return 5
 * kthLargest.add(10); // return 5
 * kthLargest.add(9); // return 8
 * kthLargest.add(4); // return 8
 */

}
