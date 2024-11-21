package algo.list.linkedlist.problems.leetcode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * 1->2->3->4
 * 2->1->4->3
 */
public class N24_Swap_Nodes_in_Pairs {

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
    public ListNode swapPairs(ListNode head) {
      ListNode dummy = new ListNode();
      dummy.next = head;

      ListNode pre = dummy;
      while(pre.next != null && pre.next.next != null) {
        ListNode l1 = pre.next, l2 = pre.next.next;
        ListNode next = l2.next;

        l1.next = next;
        l2.next = l1;
        pre.next = l2;

        pre = l1;
      }

      return dummy.next;
    }
  }

  class Solution2 {

    public ListNode swapPairs(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode next = swapPairs(head.next.next);

      ListNode result = head.next;
      result.next = head;
      head.next = next;

      return result;
    }

  }
}
