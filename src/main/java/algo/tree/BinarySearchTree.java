package algo.tree;

public class BinarySearchTree<K extends Comparable<K>> {

  BSTNode<K> root;

  public Object get(K key) {
    BSTNode<K> currentNode = root;

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

  public void put(K key, Object value) {
    BSTNode<K> currentNode = root;
    BSTNode<K> parentNode = null;

    while(currentNode != null) {
      parentNode = currentNode;

      if (key.compareTo(currentNode.key) < 0) {
        currentNode = currentNode.left;
      } else if (currentNode.key.compareTo(key) < 0) {
        currentNode = currentNode.right;
      } else {
        //key exists, update value
        currentNode.value = value;
        return;
      }
    }

    //key doesn't exist in the tree
    if (parentNode == null) { //empty tree
      root = new BSTNode<>(key, value);
    } else if (key.compareTo(parentNode.key) < 0) {
      parentNode.left = new BSTNode(key, value);
    } else {
      parentNode.right = new BSTNode(key, value);
    }
  }

  public Object min() {
    return _min(root);
  }

  private Object _min(BSTNode<K> parentNode) {
    if (parentNode == null) {
      return null;
    }

    BSTNode<K> currentNode = parentNode;
    while(currentNode.left != null) {
      currentNode = currentNode.left;
    }

    return currentNode.value;
  }

  public Object max() {
    return _max(root);
  }

  private Object _max(BSTNode<K> parentNode) {
    if (parentNode == null) {
      return null;
    }

    BSTNode<K> currentNode = parentNode;
    while(currentNode.right != null) {
      currentNode = currentNode.right;
    }

    return currentNode.value;
  }

  public Object predecessor(K key) {
    BSTNode<K> currentNode = root;
    BSTNode<K> lastNodeFromLeft = null;

    while(currentNode != null) {
      if (key.compareTo(currentNode.key) < 0) {
        currentNode = currentNode.left;
      } else if (currentNode.key.compareTo(key) < 0) {
        lastNodeFromLeft = currentNode;
        currentNode = currentNode.right;
      } else {
        break;
      }
    }

    if (currentNode == null) {
      return null;
    }

    if (currentNode.left != null) {
      return _max(currentNode.left);
    }

    return lastNodeFromLeft != null ? lastNodeFromLeft.value : null;
  }

  public Object successor(K key) {
    BSTNode<K> currentNode = root;
    BSTNode<K> lastNodeFromRight = null;

    while(currentNode != null) {
      if (key.compareTo(currentNode.key) < 0) {
        lastNodeFromRight = currentNode;
        currentNode = currentNode.left;
      } else if (currentNode.key.compareTo(key) < 0) {
        currentNode = currentNode.right;
      } else {
        break;
      }
    }

    if (currentNode == null) {
      return null;
    }

    if (currentNode.right != null) {
      return _min(currentNode.right);
    }

    return lastNodeFromRight != null ? lastNodeFromRight.value : null;
  }

  boolean isSameTree(BinarySearchTree<K> target) {
    return _isSame(root, target.root);
  }

  private boolean _isSame(BSTNode<K> left, BSTNode<K> right) {
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

  static class BSTNode<K> {

    K key;

    Object value;

    BSTNode left;

    BSTNode right;

    public BSTNode(K key, Object value) {
      this.key = key;
      this.value = value;
    }

    public BSTNode(K key, Object value, BSTNode left, BSTNode right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
}
