package algo.list.linkedlist.problems.leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 */
public class N141_Linked_List_Cycle {

  /**
   * Definition for singly-linked list.
   * class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) {
   *         val = x;
   *         next = null;
   *     }
   * }
   */
  public class Solution1 {
    public boolean hasCycle(ListNode head) {
      ListNode t = head, r = head;

      while(r != null && r.next != null) {
        t = t.next;
        r = r.next.next;

        if (t == r) {
          return true;
        }
      }

      return false;
    }
  }
}
