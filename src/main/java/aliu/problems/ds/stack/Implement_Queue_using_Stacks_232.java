package aliu.problems.ds.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
public class Implement_Queue_using_Stacks_232 {

  class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
      s2.push(x);
    }

    public int pop() {
      if (s1.isEmpty()) {
        while(!s2.isEmpty()) {
          s1.push(s2.pop());
        }
      }
      return s1.pop();
    }

    public int peek() {
      if (s1.isEmpty()) {
        while(!s2.isEmpty()) {
          s1.push(s2.pop());
        }
      }
      return s1.peek();
    }

    public boolean empty() {
      return s1.isEmpty() && s2.isEmpty();
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
