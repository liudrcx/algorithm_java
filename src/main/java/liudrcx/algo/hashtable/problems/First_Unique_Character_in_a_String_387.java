package liudrcx.algo.hashtable.problems;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 */
public class First_Unique_Character_in_a_String_387 {

  class Solution {
    public int firstUniqChar(String s) {
      int[] table = new int[26];
      char[] cs = s.toCharArray();

      for (char c : cs) {
        table[c - 97]++;
      }

      for (int i = 0; i < cs.length; i++) {
        if (table[cs[i] - 97] == 1) {
          return i;
        }
      }

      return -1;
    }
  }
}
