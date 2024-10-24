package algo.stack.problems.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class N225_Implement_Stack_using_Queues {

  class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
      int size = queue.size();
      queue.offer(x);
      for (int i = 0; i < size; i++) {
        queue.offer(queue.poll());
      }
    }

    public int pop() {
      return queue.poll();
    }

    public int top() {
      return queue.peek();
    }

    public boolean empty() {
      return queue.isEmpty();
    }
  }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
