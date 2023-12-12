package liudrcx.algo.stack.leetcode;

import java.util.Stack;

public class InfixToSuffix {

  /**
   * 思路
   *         1. 遇到数字, 拼串
   *         2. 遇到 + - * /
   *             - 优先级高于栈顶运算符 入栈
   *             - 否则将栈中高级或平级运算符出栈拼串, 本运算符入栈
   *         3. 遍历完成, 栈中剩余运算符出栈拼串
   *             - 先出栈,意味着优先运算
   *         4. 带 ()
   *             - 左括号直接入栈
   *             - 右括号要将栈中直至左括号为止的运算符出栈拼串
   */
  public String parse(String infix) {
    StringBuilder sb = new StringBuilder();

    Stack<Character> stack = new Stack<>();
    for (Character c : infix.toCharArray()) {
      switch (c) {
        case '+', '-', '*', '/' -> {
          if (stack.isEmpty()) {
            stack.push(c);
          } else {
            while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
              sb.append(stack.pop());
            }
            stack.push(c);
          }
        }
        case '(' -> stack.push(c);
        case ')' -> {
          while(!stack.isEmpty() && stack.peek() != '(') {
            sb.append(stack.pop());
          }
          stack.pop();
        }
        default -> sb.append(c);
      }
    }

    while(!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.toString();
  }

  private int priority(Character c) {
    return switch (c) {
      case '(' -> 0;
      case '+', '-' -> 1;
      case '*', '/' -> 2;
      default -> throw new IllegalArgumentException("invalid token");
    };
  }
}
