package liudrcx.algo.tree;

public class BST {

  public BSTNode root;

  public Object get(int key) {
    BSTNode p = root;
    while(p != null) {
      if (key < p.key) {
        p = p.left;
      } else if (p.key < key) {
        p = p.right;
      } else {
        return p.value;
      }
    }
    return null;
  }

  public Object min() {
    return min(root);
  }

  private Object min(BSTNode node) {
    if (node == null) {
      return null;
    }
    BSTNode p = node;
    while(p.left != null) {
      p = p.left;
    }
    return p.value;
  }

  public Object max() {
    return max(root);
  }

  private Object max(BSTNode node) {
    if (node == null) {
      return null;
    }
    BSTNode p = node;
    while(p.right != null) {
      p = p.right;
    }
    return p.value;
  }

  public void put(int key, Object value) {
    BSTNode node = root;
    BSTNode parent = null;
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
      return;
    }

    if (key < parent.key) {
      parent.left = new BSTNode(key, value);
    } else {
      parent.right = new BSTNode(key, value);
    }
  }

  public Object predecessor(int key) {
    BSTNode ancestorFromLeft = null;
    BSTNode p = root;
    while(p != null) {
      if (key < p.key) {
        p = p.left;
      } else if (p.key < key) {
        ancestorFromLeft = p;
        p = p.right;
      } else {
        break;
      }
    }

    if (p == null) {
      return null;
    }

    if (p.left != null) {
      return max(p.left);
    }

    return ancestorFromLeft != null ? ancestorFromLeft.value : null;
  }

  public Object successor(int key) {
    BSTNode ancestorFromRight = null;
    BSTNode p = root;
    while(p != null) {
      if (key < p.key) {
        ancestorFromRight = p;
        p = p.left;
      } else if(p.key < key){
        p = p.right;
      } else {
        break;
      }
    }

    if (p == null) {
      return null;
    }

    if (p.right != null) {
      return min(p.right);
    }

    return ancestorFromRight != null ? ancestorFromRight.value : null;
  }

  static class BSTNode {
    int key;
    Object value;
    BSTNode left;
    BSTNode right;

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
