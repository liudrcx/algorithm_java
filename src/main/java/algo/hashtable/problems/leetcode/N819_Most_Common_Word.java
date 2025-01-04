package algo.hashtable.problems.leetcode;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * https://leetcode.com/problems/most-common-word/description/
 */
public class N819_Most_Common_Word {

  public static void main(String[] args) {
    Solution solution = new Solution();

    String word = solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
    Assertions.assertThat(word).isEqualTo("ball");
  }

  static class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
      paragraph = paragraph.toLowerCase();
      Map<String, Integer> wordCounts = new HashMap<>();
      Set<String> bannedSet = Set.of(banned);

      StringBuilder sb = new StringBuilder();
      for (char c : paragraph.toCharArray()) {
        if (c >= 'a' && c <= 'z') {
          sb.append(c);
        } else {
          put(wordCounts, sb, bannedSet);
          sb = new StringBuilder();
        }
      }

      put(wordCounts, sb, bannedSet);

      Optional<Map.Entry<String, Integer>> max =
        wordCounts.entrySet().stream().max(Map.Entry.comparingByValue());
      return max.get().getKey();
    }

    private void put(Map<String, Integer> wordCounts, StringBuilder sb, Set<String> bannedSet) {
      if (sb.length() > 0) {
        String word = sb.toString();
        if (!bannedSet.contains(word)) {
          wordCounts.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
      }
    }
  }
}
