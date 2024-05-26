package liudrcx.problems.queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class Implement_Stack_using_Queues_225 {

  class MyStack {

    private Queue<Integer> queue = new LinkedList<Integer>();
    private int size = 0;

    public MyStack() {

    }

    public void push(int x) {
      queue.offer(x);
      for(int i = 0; i < size; i++) {
        queue.offer(queue.poll());
      }
      size++;
    }

    public int pop() {
      int value = queue.poll();
      size--;
      return value;
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
