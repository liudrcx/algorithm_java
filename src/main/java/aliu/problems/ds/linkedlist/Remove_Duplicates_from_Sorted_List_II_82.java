package aliu.problems.ds.linkedlist;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 */
public class Remove_Duplicates_from_Sorted_List_II_82 {

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
        ListNode p = head.next;
        while(p != null && p.val == head.val) {
          p = p.next;
        }
        return deleteDuplicates(p);
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

      ListNode dummy = new ListNode(-1, head);
      ListNode p1 = dummy, p2, p3;
      while((p2 = p1.next) != null && (p3 = p2.next) != null) {
        if (p2.val == p3.val) {
          while((p3 = p3.next) != null && p3.val == p2.val) {}
          p1.next = p3;
        } else {
          p1 = p1.next;
        }
      }

      return dummy.next;
    }
  }
}
