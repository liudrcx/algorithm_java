package algo.heap.problems;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 */
public class N215_Kth_Largest_Element_in_an_Array {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int kthLargest = solution.findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5);
    assertThat(kthLargest).isEqualTo(3);
  }

  static class Solution {
    public int findKthLargest(int[] nums, int k) {
      MinHeap heap = new MinHeap(k);
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

      public boolean offer(int e) {
        if (size == data.length) {
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
}
