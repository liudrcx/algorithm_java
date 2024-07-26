package aliu.problems.ds.queue;

import aliu.problems.ds.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

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

  /**
   * Using priority queue
   */
  class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists.length == 0) {
        return null;
      }

      PriorityQueue<ListNode> priorityQueue =
          new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

      for(ListNode node : lists) {
        if (node != null) {
          priorityQueue.offer(node);
        }
      }

      ListNode sentinel = new ListNode(Integer.MIN_VALUE);
      ListNode p = sentinel;
      while(!priorityQueue.isEmpty()) {
        ListNode node = priorityQueue.poll();
        p.next = node;
        p = node;

        if (node.next != null) {
          priorityQueue.offer(node.next);
        }
      }

      return sentinel.next;
    }
  }
}
