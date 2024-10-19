package algo.tree;

import org.junit.jupiter.api.Test;

import static algo.tree.BinarySearchTree.BSTNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTest {

  @Test
  public void testGet() {
       /*
                     4
                   /   \
                  2     6
                 / \   / \
                1   3 5   7
         */
    BSTNode n1 = new BSTNode(1, "1");
    BSTNode n3 = new BSTNode(3, "3");
    BSTNode n2 = new BSTNode(2, "2", n1, n3);

    BSTNode n5 = new BSTNode(5, "5");
    BSTNode n7 = new BSTNode(7, "7");
    BSTNode n6 = new BSTNode(6, "6", n5, n7);
    BSTNode root = new BSTNode(4, "4", n2, n6);

    BinarySearchTree tree = new BinarySearchTree();
    tree.root = root;

    assertEquals("1", tree.get(1));
    assertEquals("2", tree.get(2));
    assertEquals("3", tree.get(3));
    assertEquals("4", tree.get(4));
    assertEquals("5", tree.get(5));
    assertEquals("6", tree.get(6));
    assertEquals("7", tree.get(7));
    assertNull(tree.get(8));
  }

  @Test
  public void testMinAndMax() {
     /*
                     4
                   /   \
                  2     6
                 / \   / \
                1   3 5   7
         */
    BSTNode n1 = new BSTNode(1, "1");
    BSTNode n3 = new BSTNode(3, "3");
    BSTNode n2 = new BSTNode(2, "2", n1, n3);

    BSTNode n5 = new BSTNode(5, "5");
    BSTNode n7 = new BSTNode(7, "7");
    BSTNode n6 = new BSTNode(6, "6", n5, n7);
    BSTNode root = new BSTNode(4, "4", n2, n6);

    BinarySearchTree tree = new BinarySearchTree();
    tree.root = root;

    assertEquals("1",tree.min());
    assertEquals("7",tree.max());
  }

  @Test
  public void testPut() {
    /*
                     4
                   /   \
                  2     6
                 / \   / \
                1   3 5   7
         */

    BinarySearchTree tree = new BinarySearchTree();
    tree.put(4, new Object());
    tree.put(2, new Object());
    tree.put(6, new Object());
    tree.put(1, new Object());
    tree.put(3, new Object());
    tree.put(7, new Object());
    tree.put(5, new Object());


    BSTNode n1 = new BSTNode(1, "1");
    BSTNode n3 = new BSTNode(3, "3");
    BSTNode n2 = new BSTNode(2, "2", n1, n3);

    BSTNode n5 = new BSTNode(5, "5");
    BSTNode n7 = new BSTNode(7, "7");
    BSTNode n6 = new BSTNode(6, "6", n5, n7);
    BSTNode root = new BSTNode(4, "4", n2, n6);

    BinarySearchTree target = new BinarySearchTree();
    target.root = root;

    assertTrue(tree.isSameTree(target));
  }
}
