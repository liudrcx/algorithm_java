package liudrcx.problems.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

  public List<Integer> execute(Integer n, Integer m) {
    List<Integer> result = new ArrayList<>();

    Node head = createLinkedList(n);

    Node pre = null, curr = head;
    while(curr.next != curr) {
      for(int i = 0; i < m; i++) {
        pre = curr;
        curr = curr.next;
      }
      result.add(curr.num);
      pre.next = curr.next;
      curr = pre.next;
    }
    result.add(curr.num);
    return result;
  }

  private Node createLinkedList(Integer n) {
    Node dummy = new Node(-1);
    Node p = dummy;
    for (int i = 1; i <= n; i++) {
      Node node = new Node(i);
      p.next = node;
      p = p.next;
    }
    p.next = dummy.next;
    return dummy.next;
  }

  private static class Node {

    public Node(Integer num) {
      this.num = num;
    }

    Integer num;

    Node next;
  }
}
