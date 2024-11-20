package algo.list.linkedlist.problems.leetcode;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class N206_Reverse_Linked_List {

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
      ListNode prev = null, current = head;
      while(current != null) {
        ListNode next = current.next;
        current.next = prev;

        prev = current;
        current = next;
      }

      return prev;
    }
  }

  class Solution2 {
    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode result = reverseList(head.next);
      head.next.next = head;
      head.next = null;
      return result;
    }
  }
}
