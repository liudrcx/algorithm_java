package liudrcx.algo.stack.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Valid_Parentheses_20 {

  class Solution {
    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      for(Character c : s.toCharArray()) {
        if (c == '(') {
          stack.push(')');
        } else if (c == '[') {
          stack.push(']');
        } else if (c == '{') {
          stack.push('}');
        } else {
          if (!stack.isEmpty() && stack.peek() == c) {
            stack.pop();
          } else {
            return false;
          }
        }
      }
      return stack.isEmpty();
    }
  }
}
