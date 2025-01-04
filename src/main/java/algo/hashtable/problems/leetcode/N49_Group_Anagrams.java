package algo.hashtable.problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class N49_Group_Anagrams {

  class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> strMap = new HashMap<>();
      for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);

        List<String> list = strMap.computeIfAbsent(key, k -> new ArrayList<>());
        list.add(str);
      }

      return new ArrayList<>(strMap.values());
    }
  }

  class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<ArrayKey, List<String>> keyMap = new HashMap<>();
      for (String str : strs) {
        ArrayKey key = new ArrayKey(str);
        List<String> list = keyMap.computeIfAbsent(key, k -> new ArrayList<>());
        list.add(str);
      }
      return new ArrayList<>(keyMap.values());
    }

    class ArrayKey {

      int[] key = new int[26];

      public ArrayKey(String str) {
        for (char c : str.toCharArray()) {
          key[c - 'a']++;
        }
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayKey arrayKey = (ArrayKey) o;
        return Arrays.equals(key, arrayKey.key);
      }

      @Override
      public int hashCode() {
        return Arrays.hashCode(key);
      }
    }
  }
}
