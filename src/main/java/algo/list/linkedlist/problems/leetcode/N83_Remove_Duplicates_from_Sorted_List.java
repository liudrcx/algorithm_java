package algo.list.linkedlist.problems.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class N83_Remove_Duplicates_from_Sorted_List {

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

      head.next = deleteDuplicates(head.next);
      return head.val == head.next.val ? head.next : head;
    }
  }

  class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode p = head;
      while(p != null && p.next != null) {
        if (p.val == p.next.val) {
          p.next = p.next.next;
        } else {
          p = p.next;
        }

      }
      return head;
    }
  }
}
