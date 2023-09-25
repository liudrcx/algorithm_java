package liudrcx.algo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeRecursion {

  BSTNode root;

  public Object get(int key) {
    return doGet(root, key);
  }

  private Object doGet(BSTNode node, int key) {
    if (node == null) {
      return null;
    }

    if (key < node.key) {
      return doGet(node.left, key);
    } else if (node.key < key) {
      return doGet(node.right, key);
    } else {
      return node.value;
    }
  }

  public Object min() {
    return doMin(root);
  }

  private Object doMin(BSTNode node) {
    if (node == null) {
      return null;
    }

    if (node.left == null) {
      return node.value;
    }

    return doMin(node.left);
  }

  public Object max() {
    return doMax(root);
  }

  private Object doMax(BSTNode node) {
    if (node == null) {
      return null;
    }

    if (node.right == null) {
      return node.value;
    }

    return doMax(node.right);
  }

  public void put(int key, Object value) {
    if (root == null) {
      root = new BSTNode(key, value);
      return;
    }

    doPut(root, key, value);
  }

  private BSTNode doPut(BSTNode node, int key, Object value) {
    if (node == null) {
      return new BSTNode(key, value);
    }

    if (key < node.key) {
      node.left = doPut(node.left, key, value);
      return node;
    }

    if (node.key < key) {
      node.right = doPut(node.right, key, value);
      return node;
    }

    node.value = value;
    return node;
  }

  public Object delete(int key) {
    List<Object> result = new ArrayList<>();
    root = delete(root, key, result);
    return result.isEmpty() ? null : result.get(0);
  }

  private BSTNode delete(BSTNode node, int key, List<Object> result) {
    if (node == null) {
      return null;
    }

    if (key < node.key) {
      node.left = delete(node.left, key, result);
      return node;
    }

    if (node.key < key) {
      node.right = delete(node.right, key, result);
      return node;
    }

    result.add(node.value);

    if (node.left == null) {
      return node.right;
    }

    if (node.right == null) {
      return node.left;
    }

    BSTNode s = node.right;
    while(s.left != null) {
      s = s.left;
    }
    s.right = delete(node.right, s.key, new ArrayList<>());
    s.left = node.left;

    return s;
  }

  public List<Object> less(int key) {
    List<Object> result = new ArrayList<>();
    doLess(root, key, result);
    return result;
  }

  private void doLess(BSTNode node, int key, List<Object> result) {
    if (node == null) {
      return;
    }

    doLess(node.left, key, result);

    if (node.key < key) {
      result.add(node.value);
    } else {
      return;
    }

    doLess(node.right, key, result);
  }

  public List<Object> greater(int key) {
    LinkedList<Object> result = new LinkedList<>();
    doGreater(root, key, result);
    return result;
  }

  private void doGreater(BSTNode node, int key, LinkedList<Object> result) {
    if (node == null) {
      return;
    }
    doGreater(node.right, key, result);

    if (node.key > key) {
      result.addFirst(node.value);
    } else {
      return;
    }

    doGreater(node.left, key, result);
  }

  public List<Object> between(int key1, int key2) {
    List<Object> result = new ArrayList<>();
    doBetween(root, key1, key2, result);
    return result;
  }

  private void doBetween(BSTNode node, int key1, int key2, List<Object> result) {
    if (node == null) {
      return;
    }

    doBetween(node.left, key1, key2, result);

    if (node.key >= key1 && node.key <= key2) {
      result.add(node.value);
    } else if (node.key > key2) {
      return;
    }

    doBetween(node.right, key1, key2, result);
  }

  public boolean isSameTree(BinarySearchTreeRecursion target) {
    return isSameTree(root, target.root);
  }

  private boolean isSameTree(BSTNode left, BSTNode right) {
    if (left == null && right == null) {
      return true;
    }

    if (left == null || right == null) {
      return false;
    }

    if (left.key != right.key) {
      return false;
    }

    return isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
  }

  public static class BSTNode {
    private int key;
    private Object value;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int key, Object value) {
      this.key = key;
      this.value = value;
    }

    public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
}
