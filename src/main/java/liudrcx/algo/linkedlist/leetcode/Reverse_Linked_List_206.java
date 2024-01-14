package liudrcx.algo.linkedlist.leetcode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Reverse_Linked_List_206 {

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
    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode last = reverseList(head.next);
      head.next.next = head;
      head.next = null;
      return last;
    }
  }

  class Solution2 {
    public ListNode reverseList(ListNode head) {
      ListNode pre = null, curr = head;

      while(curr != null) {
        ListNode next = curr.next;
        curr.next = pre;

        pre = curr;
        curr = next;
      }

      return pre;
    }
  }

}
