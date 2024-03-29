package liudrcx.algo.hashtable.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/most-common-word/description/
 *
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 *
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 *
 *
 * Example 1:
 *
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * Example 2:
 *
 * Input: paragraph = "a.", banned = []
 * Output: "a"
 */
public class Most_Common_Word_819 {

  class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
      Set<String> bannedset = Set.of(banned);
      Map<String, Integer> wordCount = new HashMap<>();

      char[] cs = paragraph.toLowerCase().toCharArray();
      StringBuilder sb = new StringBuilder();
      for (char c : cs) {
        if (c >= 'a' && c <= 'z') {
          sb.append(c);
        } else {
          putWordCount(wordCount, bannedset, sb);
          sb = new StringBuilder();
        }
      }
      putWordCount(wordCount, bannedset,sb);

      int maxCount = 0;
      String maxWord = null;
      for(String word : wordCount.keySet()) {
        int count = wordCount.get(word);
        if (count > maxCount) {
          maxWord = word;
          maxCount = count;
        }
      }

      return maxWord;
    }

    private void putWordCount(Map<String, Integer> wordCount, Set<String> bannedset, StringBuilder sb) {
      if (sb.length() > 0) {
        String word = sb.toString();
        if (!bannedset.contains(word)) {
          wordCount.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
      }
    }
  }
}
