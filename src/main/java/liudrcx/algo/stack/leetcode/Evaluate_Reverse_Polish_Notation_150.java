package liudrcx.algo.stack.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class Evaluate_Reverse_Polish_Notation_150 {

  class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();
      for (String token : tokens) {
        switch (token) {
          case "+" -> {
            Integer b = stack.pop();
            Integer a = stack.pop();
            stack.push(a + b);
          }
          case "-" -> {
            Integer b = stack.pop();
            Integer a = stack.pop();
            stack.push(a - b);
          }
          case "*" -> {
            Integer b = stack.pop();
            Integer a = stack.pop();
            stack.push(a * b);
          }
          case "/" -> {
            Integer b = stack.pop();
            Integer a = stack.pop();
            stack.push(a / b);
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
