package liudrcx.algo.tree;

import liudrcx.algo.tree.BST.BSTNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

  @Test
  public void get() {
    BST tree = createTree();
    assertEquals("张无忌", tree.get(1));
    assertEquals("周芷若", tree.get(2));
    assertEquals("宋青书", tree.get(3));
    assertEquals("小昭", tree.get(4));
    assertEquals("说不得", tree.get(5));
    assertEquals("赵敏", tree.get(6));
    assertEquals("殷离", tree.get(7));
    assertNull(tree.get(8));
  }

  @Test
  public void minMax() {
    BST tree = createTree();
    assertEquals("张无忌", tree.min());
    assertEquals("殷离", tree.max());
  }

  @Test
  public void put() {
    BST tree = new BST();
    tree.put(4, new Object());
    tree.put(2, new Object());
    tree.put(6, new Object());
    tree.put(1, new Object());
    tree.put(3, new Object());
    tree.put(7, new Object());
    tree.put(5, new Object());
    assertTrue(isSameTree(createTree().root, tree.root));
    tree.put(1, "教主张无忌");
    assertEquals("教主张无忌", tree.get(1));
  }

  @Test
  public void predecessor() {
        /*
                     4
                   /   \
                  2     7
                 / \   / \
                1   3 6   8
                     /
                    5
         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n3 = new BSTNode(3, 3);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n5 = new BSTNode(5, 5);
    BSTNode n6 = new BSTNode(6, 6, n5, null);
    BSTNode n8 = new BSTNode(8, 8);
    BSTNode n7 = new BSTNode(7, 7, n6, n8);
    BSTNode root = new BSTNode(4, 4, n2, n7);

    BST tree = new BST();
    tree.root = root;

    assertNull(tree.predecessor(1));
    assertEquals(1, tree.predecessor(2));
    assertEquals(2, tree.predecessor(3));
    assertEquals(3, tree.predecessor(4));
    assertEquals(4, tree.predecessor(5));
    assertEquals(5, tree.predecessor(6));
    assertEquals(6, tree.predecessor(7));
    assertEquals(7, tree.predecessor(8));
  }

  @Test
  public void successor() {
        /*
                     5
                   /   \
                  2     7
                 / \   / \
                1   3 6   8
                     \
                      4
         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n4 = new BSTNode(4, 4);
    BSTNode n3 = new BSTNode(3, 3, null, n4);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n6 = new BSTNode(6, 6);
    BSTNode n8 = new BSTNode(8, 8);
    BSTNode n7 = new BSTNode(7, 7, n6, n8);
    BSTNode root = new BSTNode(5, 5, n2, n7);

    BST tree = new BST();
    tree.root = root;

    assertEquals(2, tree.successor(1));
    assertEquals(3, tree.successor(2));
    assertEquals(4, tree.successor(3));
    assertEquals(5, tree.successor(4));
    assertEquals(6, tree.successor(5));
    assertEquals(7, tree.successor(6));
    assertEquals(8, tree.successor(7));
    assertNull(tree.successor(8));
  }

  private static BST createTree() {
        /*
                     4
                   /   \
                  2     6
                 / \   / \
                1   3 5   7
         */
    BSTNode n1 = new BSTNode(1, "张无忌");
    BSTNode n3 = new BSTNode(3, "宋青书");
    BSTNode n2 = new BSTNode(2, "周芷若", n1, n3);

    BSTNode n5 = new BSTNode(5, "说不得");
    BSTNode n7 = new BSTNode(7, "殷离");
    BSTNode n6 = new BSTNode(6, "赵敏", n5, n7);
    BSTNode root = new BSTNode(4, "小昭", n2, n6);

    BST tree = new BST();
    tree.root = root;
    return tree;
  }

  private static boolean isSameTree(BSTNode tree1, BSTNode tree2) {
    if (tree1 == null && tree2 == null) {
      return true;
    }
    if (tree1 == null || tree2 == null) {
      return false;
    }
    if (tree1.key != tree2.key) {
      return false;
    }
    return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
  }

}
