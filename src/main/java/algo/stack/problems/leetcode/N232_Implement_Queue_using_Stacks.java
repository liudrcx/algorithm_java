package algo.stack.problems.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
public class N232_Implement_Queue_using_Stacks {

  class MyQueue {

    Stack<Integer> leftStack = new Stack<>();
    Stack<Integer> rightStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
      rightStack.push(x);
    }

    public int pop() {
      if (leftStack.isEmpty()) {
        while(!rightStack.empty()) {
          leftStack.push(rightStack.pop());
        }
      }
      return leftStack.pop();
    }

    public int peek() {
      if (leftStack.isEmpty()) {
        while(!rightStack.empty()) {
          leftStack.push(rightStack.pop());
        }
      }
      return leftStack.peek();
    }

    public boolean empty() {
      return leftStack.isEmpty() && rightStack.isEmpty();
    }
  }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
