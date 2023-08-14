package liudrcx.algo.linkedlist.leetcode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class Delete_Node_in_a_Linked_List_237 {

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   */
  class Solution {
    public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
    }
  }
}
