package algo.tree;

public class AVLTree<K extends Comparable<K>, V> {

  AVLNode root;


  public void put(K key, V value) {
    root = doPut(null, key, value);
  }

  AVLNode doPut(AVLNode node, K key, V value) {
    if (node == null) {
      return new AVLNode(key, value);
    }

    if (node.key.compareTo(key) == 0) {
      node.value = value;
    } else if (node.key.compareTo(key) > 0){
      node.left = doPut(node.left, key, value);
    } else {
      node.right = doPut(node.right, key, value);
    }

    updateHeight(node);
    return adjustBalance(node);
  }

  public void delete(K key) {
    root = doDelete(root, key);
  }

  AVLNode doDelete(AVLNode node, K key) {
    if (node == null) {
      return null;
    }

    if (node.key.compareTo(key) > 0) {
      node.left = doDelete(node.left, key);
    } else if (node.key.compareTo(key) < 0) {
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
    return adjustBalance(node);
  }

  public V get(K key) {
    return doGet(root, key);
  }

  private V doGet(AVLNode node, K key) {
    if (node == null) {
      return null;
    }

    if (node.key.compareTo(key) == 0) {
      return node.value;
    } else if (node.key.compareTo(key) > 0) {
      return doGet(node.left, key);
    } else {
      return doGet(node.right, key);
    }
  }

  AVLNode adjustBalance(AVLNode node) {
    if (node == null) {
      return null;
    }

    if (bf(node) > 1 && bf(node.left) >= 0) { // LL
      return rightRotate(node);
    } else if (bf(node) > 1 && bf(node.left) < 0) { //LR
      return leftRightRotate(node);
    } else if (bf(node) < -1 && bf(node.right) > 0) { //RL
      return rightLeftRotate(node);
    } else if (bf(node) < -1 && bf(node.right) <= 0) { //RR
      return leftRotate(node);
    } else {
      return node;
    }
  }

  int height(AVLNode node) {
    return node == null ? 0 : node.height;
  }

  void updateHeight(AVLNode node) {
    node.height = Integer.max(height(node.left), height(node.right));
  }

  int bf(AVLNode node) {
    return height(node.left) - height(node.right);
  }

  AVLNode leftRightRotate(AVLNode node) {
    node.left = leftRotate(node.left);
    return rightRotate(node);
  }

  AVLNode rightLeftRotate(AVLNode node) {
    node.right = rightRotate(node.right);
    return rightRotate(node);
  }

  AVLNode leftRotate(AVLNode node) {
    AVLNode right = node.right;
    AVLNode rightLeft = right.left;
    right.left = node;
    node.right = rightLeft;
    updateHeight(node);
    updateHeight(right);
    return right;
  }

  AVLNode rightRotate(AVLNode node) {
    AVLNode left = node.left;
    AVLNode leftRight = left.right;
    left.right = node;
    node.left = leftRight;
    updateHeight(node);
    updateHeight(left);
    return left;
  }

  class AVLNode {

    K key;

    V value;

    int height = 1;

    AVLNode left;

    AVLNode right;

    AVLNode(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
}
