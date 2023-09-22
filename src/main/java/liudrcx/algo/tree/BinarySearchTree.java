package liudrcx.algo.tree;

public class BinarySearchTree {

  BSTNode root;

  public Object get(int key) {
    BSTNode node = root;
    while(node != null) {
      if (key < node.key) {
        node = node.left;
      } else if (node.key < key) {
        node = node.right;
      } else {
        return node.value;
      }
    }
    return null;
  }

  public Object min() {
    BSTNode node = root;
    while(node != null && node.left != null) {
      node = node.left;
    }
    return node.value;
  }

  public Object max() {
    BSTNode node = root;
    while(node != null && node.right != null) {
      node = node.right;
    }
    return node.value;
  }

  public void put(int key, Object value) {
    BSTNode parent = null;
    BSTNode node = root;

    while(node != null) {
      parent = node;
      if (key < node.key) {
        node = node.left;
      } else if (node.key < key) {
        node = node.right;
      } else {
        node.value = value;
        return;
      }
    }

    if (parent == null) {
      root = new BSTNode(key, value);

    } else if (key < parent.key) {
      parent.left = new BSTNode(key, value);
    } else {
      parent.right = new BSTNode(key, value);
    }
  }

  public boolean isSameTree(BinarySearchTree target) {
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
