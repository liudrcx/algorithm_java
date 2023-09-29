package liudrcx.algo.tree;
public class AVLTree {

  public AVLNode root;

  private int height(AVLNode node) {
    return node == null ? 0 : node.height;
  }

  private void updateHeight(AVLNode node) {
    node.height = 1 + Integer.max(height(node.left), height(node.right));
  }

  private int bf(AVLNode node) {
    return height(node.left) - height(node.right);
  }

  private AVLNode rightRotate(AVLNode root) {
    AVLNode newRoot = root.left;
    root.left = newRoot.right;
    newRoot.right = root;
    return newRoot;
  }

  private AVLNode leftRotate(AVLNode root) {
    AVLNode newRoot = root.right;
    root.right = newRoot.left;
    newRoot.left = root;
    return newRoot;
  }

  private AVLNode leftRightRotate(AVLNode root) {
    root.left = leftRotate(root.left);
    return rightRotate(root);
  }

  private AVLNode rightLeftRotate(AVLNode root) {
    root.right = rightRotate(root.right);
    return leftRotate(root);
  }

  private AVLNode balance(AVLNode node) {
    if (node == null) {
      return null;
    }

    int bf = bf(node);
    if (bf > 1 && bf(node.left) >= 0) { //LL
      return rightRotate(node);
    } else if(bf > 1 && bf(node.left) < 0){ //LR
      return leftRightRotate(node);
    } else if (bf < -1 && bf(node.right) > 0) { //RL
      return rightLeftRotate(node);
    } else if (bf < -1 && bf(node.right) <= 0){ //RR
      return leftRotate(node);
    }
    return node;
  }

  public void put(int key, Object value) {
    root = doPut(null, key, value);
  }

  private AVLNode doPut(AVLNode node, int key, Object value) {
    if (node == null) {
      return new AVLNode(key, value);
    }

    if (key == node.key) {
      node.value = value;
    } else if (key < node.key) {
      node.left = doPut(node.left, key, value);
    } else {
      node.right = doPut(node.right, key, value);
    }

    updateHeight(node);
    return balance(node);
  }

  public void delete(int key) {
    root = doDelete(root, key);
  }

  private AVLNode doDelete(AVLNode node, int key) {
    if (node == null) {
      return null;
    }

    if (key < node.key) {
      node.left = doDelete(node.left, key);
    } else if (node.key < key) {
      node.right = doDelete(node.right, key);
    } else {
      if (node.left == null && node.right == null) {
        return null;
      } else if (node.left == null) {
        node = node.right;
      } else if (node.right == null) {
        node = node.left;
      } else {
        AVLNode s = node.right;
        while(s.left != null) {
          s = s.left;
        }
        s.right = doDelete(node.right, s.key);
        s.left = node.left;
        node = s;
      }
    }

    updateHeight(node);
    return balance(node);
  }

  public Object get(int key) {
    return doGet(root, key);
  }

  private Object doGet(AVLNode node, int key) {
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

  public static class AVLNode {
    int key;
    Object value;
    int height = 1;
    AVLNode left;
    AVLNode right;

    public AVLNode(int key, Object value) {
      this.key = key;
      this.value = value;
    }

    public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
}
