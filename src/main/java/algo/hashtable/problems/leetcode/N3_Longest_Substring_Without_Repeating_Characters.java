package algo.hashtable.problems.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class N3_Longest_Substring_Without_Repeating_Characters {

  class Solution1 {
    public int lengthOfLongestSubstring(String s) {
      int max = 0;

      Map<Character, Integer> cMap = new HashMap<>();
      int begin = 0;
      for (int end = 0; end < s.length(); end++) {
        Character c = s.charAt(end);
        if (cMap.containsKey(c)) {
          begin = Integer.max(begin, cMap.get(c) + 1);
        }
        cMap.put(c, end);
        max = Integer.max(max, end - begin + 1);
      }

      return max;
    }
  }

  class Solution2 {
    public int lengthOfLongestSubstring(String s) {
      int max = 0;

      int[] cArr = new int[128];
      Arrays.fill(cArr, -1);
      int begin = 0;
      for (int end = 0; end < s.length(); end++) {
        Character c = s.charAt(end);
        if (cArr[c] != -1) {
          begin = Integer.max(begin, cArr[c] + 1);
        }
        cArr[c] = end;
        max = Integer.max(max, end - begin + 1);
      }

      return max;
    }
  }
}
