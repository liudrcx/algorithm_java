package liudrcx.algo.hashtable.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class Valid_Anagram_242 {

  class Solution {
    public boolean isAnagram(String s, String t) {
      return Arrays.equals(getTable(s), getTable(t));
    }

    private int[] getTable(String s) {
      int[] result = new int[26];
      for (char c : s.toCharArray()) {
        result[c - 97]++;
      }
      return result;
    }
  }
}
