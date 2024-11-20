package algo.list.linkedlist.problems.leetcode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class N19_Remove_Nth_Node_From_End_of_List {

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode();
      dummy.next = head;
      ListNode slow = dummy, fast = dummy;

      for (int i = 0; i < n; i++) {
        fast = fast.next;
      }

      while(fast.next != null) {
        slow = slow.next;
        fast = fast.next;
      }

      slow.next = slow.next.next;
      return dummy.next;
    }
  }

}
