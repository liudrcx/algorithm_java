package liudrcx.algo.heap.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class Find_Median_from_Data_Stream_295 {

  class MedianFinder {

    private PriorityQueue<Integer> leftMaxQueue;
    private PriorityQueue<Integer> rightMinQueue;

    public MedianFinder() {
      leftMaxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
      rightMinQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    }

    public void addNum(int num) {
      if (leftMaxQueue.size() == rightMinQueue.size()) {
        rightMinQueue.offer(num);
        leftMaxQueue.offer(rightMinQueue.poll());
      } else {
        leftMaxQueue.offer(num);
        rightMinQueue.offer(leftMaxQueue.poll());
      }
    }

    public double findMedian() {
      if (leftMaxQueue.size() == rightMinQueue.size()) {
        return (leftMaxQueue.peek() + rightMinQueue.peek()) / 2.0;
      } else {
        return leftMaxQueue.peek();
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
