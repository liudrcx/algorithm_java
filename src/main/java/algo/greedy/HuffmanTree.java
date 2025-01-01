package algo.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {

  private String str;

  private Node root;

  private Map<Character, Node> cMap = new HashMap<>();

  public HuffmanTree(String str) {
    this.str = str;
    init();
    System.out.println();
  }

  private void init() {
    for (char c : str.toCharArray()) {
      cMap.computeIfAbsent(c,  Node::new);
      cMap.get(c).freq++;
    }

    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getFreq));
    cMap.values().forEach(queue::offer);

    while(queue.size() > 1) {
      Node lc = queue.poll();
      Node rc = queue.poll();
      queue.offer(new Node(lc.freq + rc.freq, lc, rc));
    }
    root = queue.poll();

    createCode(root, new StringBuilder());
  }

  private void createCode(Node root, StringBuilder sb) {
    if (root.isLeaf()) {
      root.code = sb.toString();
    } else {
      createCode(root.left, sb.append("0"));
      createCode(root.right, sb.append("1"));
    }

    if (!sb.isEmpty()) {
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public String encode() {
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      sb.append(cMap.get(c).code);
    }
    return sb.toString();
  }

  public String decode(String target) {
    char[] chars = target.toCharArray();
    StringBuilder sb = new StringBuilder();
    Node node = root;

    int i = 0;
    while(i < chars.length) {
      if (!node.isLeaf()) {
        if (chars[i] == '0') {
          node = node.left;
        } else {
          node = node.right;
        }
        i++;
      }

      if (node.isLeaf()) {
        sb.append(node.c);
        node = root;
      }
    }

    return sb.toString();
  }

  class Node {

    Character c;

    int freq = 0;

    String code;

    Node left;

    Node right;

    Node() {}

    Node(Character c) {
      this.c = c;
    }

    Node(int freq, Node left, Node right) {
      this.freq = freq;
      this.left = left;
      this.right = right;
    }

    int getFreq() {
      return freq;
    }

    boolean isLeaf() {
      return left == null;
    }
  }
}
