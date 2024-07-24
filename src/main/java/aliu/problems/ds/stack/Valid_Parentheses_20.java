package aliu.problems.ds.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
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
