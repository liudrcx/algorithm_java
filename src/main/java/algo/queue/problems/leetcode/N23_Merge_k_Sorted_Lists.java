package algo.queue.problems.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class N23_Merge_k_Sorted_Lists {

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
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return null;
      }

      if (lists.length == 1) {
        return lists[0];
      }

      PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
      for (ListNode list : lists) {
        if (list != null) {
          queue.offer(list);
        }
      }

      ListNode dummy = new ListNode(Integer.MIN_VALUE);
      ListNode p = dummy;
      while(!queue.isEmpty()) {
        ListNode node = queue.poll();
        p.next = node;
        p = p.next;

        if (node.next != null) {
          queue.offer(node.next);
        }
      }

      return dummy.next;
    }
  }
}
