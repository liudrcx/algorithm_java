package aliu.problems.ds.linkedlist;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 */
public class Intersection_of_Two_Linked_Lists_160 {

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) {
   *         val = x;
   *         next = null;
   *     }
   * }
   */
  public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode p1 = headA, p2 = headB;
      while(true) {
        if (p1 == p2) {
          return p1;
        }

        if (p1 == null) {
          p1 = headB;
        } else {
          p1 = p1.next;
        }

        if (p2 == null) {
          p2 = headA;
        } else {
          p2 = p2.next;
        }
      }
    }
  }
}
