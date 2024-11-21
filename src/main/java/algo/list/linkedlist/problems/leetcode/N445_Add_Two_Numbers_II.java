package algo.list.linkedlist.problems.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 */
public class N445_Add_Two_Numbers_II {

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode();

      Stack<Integer> stack1 = createStack(l1);
      Stack<Integer> stack2 = createStack(l2);
      int carry = 0;
      while(!stack1.empty() || !stack2.isEmpty() || carry != 0) {
        int x1 = stack1.isEmpty() ? 0 : stack1.pop();
        int x2 = stack2.isEmpty() ? 0 : stack2.pop();
        int sum = x1 + x2 + carry;

        ListNode node = new ListNode(sum % 10);
        node.next = dummy.next;
        dummy.next = node;

        carry = sum / 10;
      }

      return dummy.next;
    }

    private Stack<Integer> createStack(ListNode list) {
      Stack<Integer> result = new Stack<>();
      ListNode p = list;
      while(p != null) {
        result.push(p.val);
        p = p.next;
      }
      return result;
    }
  }
}
