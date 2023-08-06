package liudrcx.algo.linkedlist.leetcode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class Remove_Nth_Node_From_End_of_List_19 {

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
  class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(-1, head);
      ListNode p1 = dummy, p2 = dummy;

      for(int i = 0; i < n + 1; i++) {
        p2 = p2.next;
      }

      while(p2 != null) {
        p1 = p1.next;
        p2 = p2.next;
      }
      p1.next = p1.next.next;
      return dummy.next;
    }
  }

  class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(-1, head);
      _removeNthFromEnd(dummy, n);
      return dummy.next;
    }

    private int _removeNthFromEnd(ListNode head, int n) {
      if (head == null) {
        return 0;
      }

      int nth = _removeNthFromEnd(head.next, n);
      if (nth == n) {
        head.next = head.next.next;
      }
      return nth + 1;
    }
  }
}
