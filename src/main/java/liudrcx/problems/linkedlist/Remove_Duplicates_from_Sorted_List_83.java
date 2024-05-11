package liudrcx.problems.linkedlist;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Remove_Duplicates_from_Sorted_List_83 {

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
    public ListNode deleteDuplicates(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      if (head.val == head.next.val) {
        return deleteDuplicates(head.next);
      } else {
        head.next = deleteDuplicates(head.next);
        return head;
      }
    }
  }

  class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode p1 = head, p2 = p1.next;
      while(p2 != null) {
        if (p1.val == p2.val) {
          p1.next = p2.next;
        } else {
          p1 = p1.next;
        }
        p2 = p2.next;
      }

      return head;
    }
  }
}
