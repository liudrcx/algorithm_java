package liudrcx.algo.linkedlist.leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class Middle_of_the_Linked_List_876 {

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
    public ListNode middleNode(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode slow = head, fast = head;
      while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      return slow;
    }
  }
}
