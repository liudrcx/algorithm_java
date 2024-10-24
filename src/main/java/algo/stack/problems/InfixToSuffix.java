package algo.stack.problems;

import java.util.Stack;

public class InfixToSuffix {

  public String eval(String infix) {
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (Character c : infix.toCharArray()) {
      switch (c) {
        case '+', '-', '*', '/' -> {
          if (stack.isEmpty()) {
            stack.push(c);
          } else {
            if (priority(c) > priority(stack.peek())) {
              stack.push(c);
            } else {
              while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                sb.append(stack.pop());
              }
              stack.push(c);
            }
          }
        }
        case '(' -> {
          stack.push(c);
        }
        case ')' -> {
          while (!stack.isEmpty() && stack.peek() != '(') {
            sb.append(stack.pop());
          }
          stack.pop();
        }
        default -> {
          sb.append(c);
        }
      }
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.toString();
  }

  private int priority(char c) {
    if (c == '*' || c == '/') {
      return 2;
    }

    if (c == '+' ||c == '-') {
      return 1;
    }

    if (c == '(') {
      return 0;
    }

    throw new IllegalArgumentException("invalid operator");
  }
}
