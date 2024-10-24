package algo.stack.problems.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class N150_Evaluate_Reverse_Polish_Notation {

  class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();
      for (String token : tokens) {
        switch (token) {
          case "+" -> {
            int right = stack.pop();
            int left = stack.pop();
            stack.push(left + right);
          }
          case "-" -> {
            int right = stack.pop();
            int left = stack.pop();
            stack.push(left - right);
          }
          case "*" -> {
            int right = stack.pop();
            int left = stack.pop();
            stack.push(left * right);
          }
          case "/" -> {
            int right = stack.pop();
            int left = stack.pop();
            stack.push(left / right);
          }
          default -> {
            stack.push(Integer.parseInt(token));
          }
        }
      }
      return stack.pop();
    }
  }
}
