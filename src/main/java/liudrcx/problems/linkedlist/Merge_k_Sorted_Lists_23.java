package liudrcx.problems.linkedlist;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Merge_k_Sorted_Lists_23 {

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
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists.length == 0) {
        return null;
      }

      return split(lists, 0, lists.length - 1);
    }

    private ListNode split(ListNode[] lists, int i, int j) {
      if (j == i) {
        return lists[i];
      }

      int m = (i + j) >>> 1;
      ListNode left = split(lists, i, m);
      ListNode right = split(lists, m + 1, j);
      return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(Integer.MIN_VALUE), p = dummy;
      ListNode p1 = l1, p2 = l2;

      while(p1 != null && p2 != null) {
        if (p1.val < p2.val) {
          p.next = p1;
          p1 = p1.next;
        } else {
          p.next = p2;
          p2 = p2.next;
        }
        p = p.next;
      }

      if (p1 != null) {
        p.next = p1;
      }

      if (p2 != null) {
        p.next = p2;
      }

      return dummy.next;
    }
  }
}
