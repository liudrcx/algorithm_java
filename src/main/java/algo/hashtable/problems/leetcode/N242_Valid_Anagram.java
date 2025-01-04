package algo.hashtable.problems.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class N242_Valid_Anagram {

  class Solution1 {
    public boolean isAnagram(String s, String t) {
      return sortStr(s).equals(sortStr(t));
    }

    private String sortStr(String str) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      return new String(chars);
    }
  }

  class Solution2 {
    public boolean isAnagram(String s, String t) {
      return Arrays.equals(key(s), key(t));
    }

    private int[] key(String str) {
      int[] result = new int[26];
      for (char c : str.toCharArray()) {
        result[c - 'a']++;
      }
      return result;
    }
  }
}
