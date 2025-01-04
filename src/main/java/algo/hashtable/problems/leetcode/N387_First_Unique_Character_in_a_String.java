package algo.hashtable.problems.leetcode;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class N387_First_Unique_Character_in_a_String {

  class Solution {
    public int firstUniqChar(String s) {
      char[] chars = s.toCharArray();

      int[] cArr = new int[26];
      for (char c : chars) {
        cArr[c - 'a']++;
      }

      for (int i = 0; i < chars.length; i++) {
        if (cArr[chars[i] - 'a'] == 1) {
          return i;
        }
      }

      return -1;
    }
  }
}
