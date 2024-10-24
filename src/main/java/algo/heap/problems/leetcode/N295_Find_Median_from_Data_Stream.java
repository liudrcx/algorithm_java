package algo.heap.problems.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
public class N295_Find_Median_from_Data_Stream {

  class MedianFinder {

    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);

    public MedianFinder() {

    }

    public void addNum(int num) {
      if (left.size() == right.size()) {
        right.offer(num);
        left.offer(right.poll());
      } else {
        left.offer(num);
        right.offer(left.poll());
      }
    }

    public double findMedian() {
      if (left.size() == right.size()) {
        return (left.peek() + right.peek()) / 2.0;
      } else {
        return left.peek();
      }
    }
  }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
