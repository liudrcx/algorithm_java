package liudrcx.algo.hashtable.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class Group_Anagrams_49 {

  class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> strMap = new HashMap<>();
      for (String str : strs) {
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        String key = new String(cs);
        List<String> list = strMap.computeIfAbsent(key, k -> new ArrayList<>());
        list.add(str);
      }
      return new ArrayList<>(strMap.values());
    }
  }

  class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<Key, List<String>> strMap = new HashMap<>();
      for (String str : strs) {
        Key key = new Key(str);
        List<String> list = strMap.computeIfAbsent(key, k -> new ArrayList<>());
        list.add(str);
      }
      return new ArrayList<>(strMap.values());
    }

    class Key {
      int[] table = new int[26];

      Key(String str) {
        for (char c : str.toCharArray()) {
          table[c - 97]++;
        }
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Arrays.equals(table, key.table);
      }

      @Override
      public int hashCode() {
        return Arrays.hashCode(table);
      }
    }
  }
}
