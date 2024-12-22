package algo.list.linkedlist.problems.leetcode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class N234_Palindrome_Linked_List {

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
    //1 2 3 2 1
    public boolean isPalindrome(ListNode head) {
      if (head == null && head.next == null) {
        return true;
      }

      ListNode middle = findMiddle(head);
      ListNode reversed = reverse(middle);

      ListNode p1 = head, p2 = reversed;
      while(p2 != null) {
        if (p1.val != p2.val) {
          return false;
        }
        p1 = p1.next;
        p2 = p2.next;
      }
      return true;
    }

    private ListNode findMiddle(ListNode head) {
      ListNode slow = head, fast = head;
      while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      return slow;
    }

    private ListNode reverse(ListNode head) {
      ListNode pre = null, curr = head;
      while(curr != null) {
        ListNode next = curr.next;
        curr.next = pre;

        pre = curr;
        curr = next;
      }
      return pre;
    }
  }

  class Solution2 {

    public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) {
        return true;
      }

      ListNode p1 = head, p2 = head;
      ListNode n1 = null, o1 = head;
      while(p2 != null && p2.next != null) {
        p1 = p1.next;
        p2 = p2.next.next;

        //reverse linked list
        o1.next = n1;
        n1 = o1;
        o1 = p1;
      }

      if (p2 != null) {
        p1 = p1.next;
      }

      while(n1 != null) {
        if (n1.val != p1.val) {
          return false;
        }

        p1 = p1.next;
        n1 = n1.next;
      }

      return true;
    }

  }
}
