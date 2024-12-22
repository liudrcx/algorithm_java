package algo.list.linkedlist.problems.leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
public class N142_Linked_List_Cycle_II {

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
  public class Solution {
    public ListNode detectCycle(ListNode head) {
      ListNode t = head, r = head;
      while(r != null && r.next != null) {
        t = t.next;
        r = r.next.next;

        if (r == t) {
          t = head;
          while(t != r) {
            t = t.next;
            r = r.next;
          }
          return t;
        }
      }

      return null;
    }
  }
}
