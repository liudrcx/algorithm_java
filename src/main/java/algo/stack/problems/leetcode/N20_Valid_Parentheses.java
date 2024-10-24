package algo.stack.problems.leetcode;


import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class N20_Valid_Parentheses {

  class Solution {
    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();

      for (Character c : s.toCharArray()) {
        if (c == '{') {
          stack.push('}');
        } else if (c == '[') {
          stack.push(']');
        } else if (c == '(') {
          stack.push(')');
        } else {
          if (stack.isEmpty() || stack.peek() != c) {
            return false;
          } else {
            stack.pop();
          }
        }
      }

      return stack.isEmpty();
    }
  }
}
