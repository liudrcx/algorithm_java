package aliu.problems.ds.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class Evaluate_Reverse_Polish_Notation_150 {

  class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();

      for(String token : tokens) {
        switch(token) {
          case "+" -> {
            Integer right = stack.pop();
            Integer left = stack.pop();
            stack.push(left + right);
          }
          case "-" -> {
            Integer right = stack.pop();
            Integer left = stack.pop();
            stack.push(left - right);
          }
          case "*" -> {
            Integer right = stack.pop();
            Integer left = stack.pop();
            stack.push(left * right);
          }
          case "/" -> {
            Integer right = stack.pop();
            Integer left = stack.pop();
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
