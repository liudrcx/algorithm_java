package liudrcx.algo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
    return min(root);
  }

  public Object min(BSTNode root) {
    BSTNode node = root;
    while(node != null && node.left != null) {
      node = node.left;
    }
    return node.value;
  }

  public Object max() {
    return max(root);
  }

  private Object max(BSTNode root) {
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

  public Object predecessor(int key) {
    BSTNode node = root;
    BSTNode leftFromParent = null;
    while(node != null) {
      if (key < node.key) {
        node = node.left;
      } else if (node.key < key) {
        leftFromParent = node;
        node = node.right;
      } else {
        break;
      }
    }

    if (node == null) {
      return null;
    }

    if (node.left != null) {
      return max(node.left);
    }

    if (leftFromParent != null) {
      return leftFromParent.value;
    }

    return null;
  }

  public Object successor(int key) {
    BSTNode node = root;
    BSTNode leftFromParent = null;
    while(node != null) {
      if (key < node.key) {
        leftFromParent = node;
        node = node.left;
      } else if(node.key < key){
        node = node.right;
      } else {
        break;
      }
    }

    if (node == null) {
      return null;
    }

    if (node.right != null) {
      return min(node.right);
    }

    if (leftFromParent != null) {
      return leftFromParent.value;
    }

    return null;
  }

  public Object delete(int key) {
    BSTNode parent = null;
    BSTNode node = root;
    while(node != null) {
      if (key < node.key) {
        parent = node;
        node = node.left;
      } else if(node.key < key){
        parent = node;
        node = node.right;
      } else {
        break;
      }
    }

    if (node == null) {
      return null;
    }

    if (node.left == null) {
      shiftForDelete(parent, node, node.right);
    } else if(node.right == null){
      shiftForDelete(parent, node, node.left);
    } else {
      BSTNode s = node.right;
      BSTNode sp = node;
      while(s.left != null) {
        sp = s;
        s = s.left;
      }

      shiftForDelete(sp, s, s.right);
      shiftForDelete(parent, node, s);
      s.left = node.left;
      s.right = node.right;
    }

    return node.value;
  }

  private void shiftForDelete(BSTNode parent, BSTNode toDelete, BSTNode child) {
    if (parent == null) {
      root = child;
    } else if (parent.left == toDelete) {
      parent.left = child;
    } else {
      parent.right = child;
    }
  }

  public Object deleteByRecursion(int key) {
    List<Object> result = new ArrayList<>();
    root = deleteByRecursion(root, key, result);
    return result.isEmpty() ? null : result.get(0);
  }

  private BSTNode deleteByRecursion(BSTNode node, int key, List<Object> result) {
    if (node == null) {
      return null;
    }

    if (key < node.key) {
      node.left = deleteByRecursion(node.left, key, result);
      return node;
    }

    if (node.key < key) {
      node.right = deleteByRecursion(node.right, key, result);
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
    s.right = deleteByRecursion(node.right, s.key, new ArrayList<>());
    s.left = node.left;

    return s;
  }

  public List<Object> less(int key) {
    List<Object> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Stack<BSTNode> stack = new Stack<>();
    BSTNode node = root;

    while(node != null || !stack.isEmpty()) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        BSTNode pop = stack.pop();
        if (pop.key < key) {
          result.add(pop.value);
        } else {
          break;
        }
        node = pop.right;
      }
    }
    return result;
  }

  public List<Object> greater(int key) {
    List<Object> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Stack<BSTNode> stack = new Stack<>();
    BSTNode node = root;

    while(node != null || !stack.isEmpty()) {
      if (node != null) {
        stack.push(node);
        node = node.right;
      } else {
        BSTNode pop = stack.pop();
        if (pop.key > key) {
          result.add(pop.value);
        } else {
          break;
        }
        node = pop.left;
      }
    }

    Collections.reverse(result);
    return result;
  }

  public List<Object> between(int key1, int key2) {
    List<Object> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Stack<BSTNode> stack = new Stack<>();
    BSTNode node = root;
    while(node != null || !stack.isEmpty()) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        BSTNode pop = stack.pop();
        if (pop.key >= key1 && pop.key <= key2) {
          result.add(pop.value);
        } else if (pop.key > key2){
          break;
        }
        node = pop.right;
      }
    }

    return result;
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
