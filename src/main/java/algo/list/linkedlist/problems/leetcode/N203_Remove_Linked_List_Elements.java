package algo.list.linkedlist.problems.leetcode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */
public class N203_Remove_Linked_List_Elements {

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
    public ListNode removeElements(ListNode head, int val) {
      ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
      ListNode p1 = dummy, p2 = head;

      while(p2 != null) {
        if (p2.val == val) {
          p1.next = p2.next;
        } else {
          p1 = p1.next;
        }
        p2 = p2.next;
      }

      return dummy.next;
    }
  }

  class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
      if (head == null) {
        return null;
      }

      ListNode next = removeElements(head.next, val);
      if (head.val == val) {
        return next;
      } else {
        head.next = next;
        return head;
      }
    }
  }

}
