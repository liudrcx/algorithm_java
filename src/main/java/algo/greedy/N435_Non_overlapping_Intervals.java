package algo.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 */
public class N435_Non_overlapping_Intervals {

  class Solution1 {
    public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
      int result = 1;
      int[] prev = intervals[0];
      for (int i = 1; i < intervals.length; i++) {
        int[] current = intervals[i];
        if (prev[1] <= current[0]) {
          result++;
          prev = current;
        }
      }
      return intervals.length - result;
    }
  }
}
