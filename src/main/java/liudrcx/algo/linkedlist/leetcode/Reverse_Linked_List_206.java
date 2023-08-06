package liudrcx.algo.linkedlist.leetcode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Reverse_Linked_List_206 {

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
    public ListNode reverseList(ListNode head) {
      ListNode newList = null;
      ListNode p = head;

      while(p != null) {
        newList = new ListNode(p.val, newList);
        p = p.next;
      }

      return newList;
    }
  }

  class Solution2 {
    public ListNode reverseList(ListNode head) {
      List l1 = new List(head);
      List l2 = new List(null);

      ListNode node;
      while((node = l1.removeFirst()) != null) {
        l2.addFirst(node);
      }

      return l2.head;
    }

    private static class List {
      ListNode head;

      public List(ListNode head) {
        this.head = head;
      }

      public ListNode removeFirst() {
        ListNode first = head;
        if (first != null) {
          head = first.next;
        }
        return first;
      }

      public void addFirst(ListNode first) {
        first.next = head;
        head = first;
      }
    }
  }

  class Solution3 {
    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode last = reverseList(head.next);
      head.next.next = head;
      head.next = null;
      return last;
    }
  }

  class Solution4 {
    public ListNode reverseList(ListNode head) {
      return null;
    }
  }

  class Solution5 {
    public ListNode reverseList(ListNode head) {
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

}
