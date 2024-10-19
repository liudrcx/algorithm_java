package algo.tree;

public class BinarySearchTree<K extends Comparable<K>, V> {

  BSTNode<K, V> root;

  public V get(K key) {
    BSTNode<K, V> currentNode = root;

    while(currentNode != null) {
      if (key.compareTo(currentNode.key) < 0) {
        currentNode = currentNode.left;
      } else if (currentNode.key.compareTo(key) < 0) {
        currentNode = currentNode.right;
      } else {
        return currentNode.value;
      }
    }

    return null;
  }

  public V min() {
    return min(root);
  }

  private V min(BSTNode<K, V> node) {
    if (node == null) {
      return null;
    }

    BSTNode<K, V> currentNode = node;

    while(currentNode.left != null) {
      currentNode = currentNode.left;
    }

    return currentNode.value;
  }

  public V max() {
    return max(root);
  }

  public V max(BSTNode<K, V> node) {
    if (node == null) {
      return null;
    }

    BSTNode<K, V> currentNode = node;

    while(currentNode.right != null) {
      currentNode = currentNode.right;
    }

    return currentNode.value;
  }

  public void put(K key, V value) {
    BSTNode<K, V> currentNode = root;
    BSTNode<K, V> parentNode = null;

    while(currentNode != null) {
      parentNode = currentNode;
      if (key.compareTo(currentNode.key) < 0) {
        currentNode = currentNode.left;
      } else if (currentNode.key.compareTo(key) < 0) {
        currentNode = currentNode.right;
      } else {
        currentNode.value = value;
        return;
      }
    }

    if (parentNode == null) {
      root = new BSTNode<>(key, value);
    } else if (key.compareTo(parentNode.key) < 0) {
      parentNode.left = new BSTNode<>(key, value);
    } else {
      parentNode.right = new BSTNode<>(key, value);
    }
  }

  public boolean isSameTree(BinarySearchTree<K, V> targetTree) {
    return _isSame(root, targetTree.root);
  }

  private boolean _isSame(BSTNode<K, V> left, BSTNode<K, V> right) {
    if (left == null && right == null) {
      return true;
    }

    if (left == null || right == null) {
      return false;
    }

    if (left.key.compareTo(right.key) != 0) {
      return false;
    }

    return _isSame(left.left, right.left) && _isSame(left.right, right.right);
  }

  static class BSTNode<K, V> {

    K key;

    V value;

    BSTNode<K, V> left;

    BSTNode<K, V> right;


    public BSTNode(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
}
