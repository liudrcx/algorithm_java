package liudrcx.algo.linkedlist.leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class Linked_List_Cycle_141 {

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
