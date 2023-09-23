package liudrcx.algo.tree;

import liudrcx.algo.tree.BinarySearchTree.BSTNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

  @Test
  public void testGet() {
    BinarySearchTree tree = createTree();
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
  public void testMinMax() {
    BinarySearchTree tree = createTree();
    assertEquals("张无忌", tree.min());
    assertEquals("殷离", tree.max());
  }

  @Test
  public void testPut() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.put(4, new Object());
    tree.put(2, new Object());
    tree.put(6, new Object());
    tree.put(1, new Object());
    tree.put(3, new Object());
    tree.put(7, new Object());
    tree.put(5, new Object());
    assertTrue(tree.isSameTree(createTree()));
    tree.put(1, "教主张无忌");
    assertEquals("教主张无忌", tree.get(1));
  }

  @Test
  public void testPredecessor() {
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

    BinarySearchTree tree = new BinarySearchTree();
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
  public void testSuccessor() {
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

    BinarySearchTree tree = new BinarySearchTree();
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

  @Test
  public void testDeleteLeafChild() {
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
    BSTNode root1 = new BSTNode(4, 4, n2, n7);

    BinarySearchTree tree1 = new BinarySearchTree();
    tree1.root = root1;

    assertEquals(1, tree1.delete(1));
    assertEquals(3, tree1.delete(3));
    assertEquals(5, tree1.delete(5));
    assertEquals(8, tree1.delete(8));

        /*
                     4
                   /   \
                  2     7
                       /
                      6
         */
    BSTNode x2 = new BSTNode(2, 2);
    BSTNode x6 = new BSTNode(6, 6);
    BSTNode x7 = new BSTNode(7, 7, x6, null);
    BSTNode root2 = new BSTNode(4, 4, x2, x7);
    BinarySearchTree tree2 = new BinarySearchTree();
    tree2.root = root2;

    assertTrue(tree1.isSameTree(tree2));
  }

  @Test
  public void testRecursionDeleteLeafChild() {
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
    BSTNode root1 = new BSTNode(4, 4, n2, n7);

    BinarySearchTree tree1 = new BinarySearchTree();
    tree1.root = root1;

    assertEquals(1, tree1.deleteByRecursion(1));
    assertEquals(3, tree1.deleteByRecursion(3));
    assertEquals(5, tree1.deleteByRecursion(5));
    assertEquals(8, tree1.deleteByRecursion(8));

        /*
                     4
                   /   \
                  2     7
                       /
                      6
         */
    BSTNode x2 = new BSTNode(2, 2);
    BSTNode x6 = new BSTNode(6, 6);
    BSTNode x7 = new BSTNode(7, 7, x6, null);
    BSTNode root2 = new BSTNode(4, 4, x2, x7);
    BinarySearchTree tree2 = new BinarySearchTree();
    tree2.root = root2;

    assertTrue(tree1.isSameTree(tree2));
  }

  @Test
  public void testDeleteNodeWithOnlyOneChild() {
        /*
                     4
                   /   \
                  2     7
                 / \   /
                1   3 6
                     /
                    5
         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n3 = new BSTNode(3, 3);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n5 = new BSTNode(5, 5);
    BSTNode n6 = new BSTNode(6, 6, n5, null);
    BSTNode n7 = new BSTNode(7, 7, n6, null);
    BSTNode root1 = new BSTNode(4, 4, n2, n7);

    BinarySearchTree tree1 = new BinarySearchTree();
    tree1.root = root1;

    assertEquals(7, tree1.delete(7));

        /*
                     4
                   /   \
                  2     6
                 / \   /
                1   3 5
         */
    BSTNode x1 = new BSTNode(1, 1);
    BSTNode x3 = new BSTNode(3, 3);
    BSTNode x2 = new BSTNode(2, 2, x1, x3);
    BSTNode x5 = new BSTNode(5, 5);
    BSTNode x6 = new BSTNode(6, 6, x5, null);
    BSTNode root2 = new BSTNode(4, 4, x2, x6);
    BinarySearchTree tree2 = new BinarySearchTree();
    tree2.root = root2;

    assertTrue(tree1.isSameTree(tree2));
  }

  @Test
  public void testRecursionDeleteNodeWithOnlyOneChild() {
        /*
                     4
                   /   \
                  2     7
                 / \   /
                1   3 6
                     /
                    5
         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n3 = new BSTNode(3, 3);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n5 = new BSTNode(5, 5);
    BSTNode n6 = new BSTNode(6, 6, n5, null);
    BSTNode n7 = new BSTNode(7, 7, n6, null);
    BSTNode root1 = new BSTNode(4, 4, n2, n7);

    BinarySearchTree tree1 = new BinarySearchTree();
    tree1.root = root1;

    assertEquals(7, tree1.deleteByRecursion(7));

        /*
                     4
                   /   \
                  2     6
                 / \   /
                1   3 5
         */
    BSTNode x1 = new BSTNode(1, 1);
    BSTNode x3 = new BSTNode(3, 3);
    BSTNode x2 = new BSTNode(2, 2, x1, x3);
    BSTNode x5 = new BSTNode(5, 5);
    BSTNode x6 = new BSTNode(6, 6, x5, null);
    BSTNode root2 = new BSTNode(4, 4, x2, x6);
    BinarySearchTree tree2 = new BinarySearchTree();
    tree2.root = root2;

    assertTrue(tree1.isSameTree(tree2));
  }

  @Test
  public void testDeleteNodeWithTwoChildren1() {
        /*
                      4
                   /     \
                  2      7
                 / \   /   \
                1   3 5     8
                       \
                        6
         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n3 = new BSTNode(3, 3);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n6 = new BSTNode(6, 6);
    BSTNode n5 = new BSTNode(5, 5, null, n6);
    BSTNode n8 = new BSTNode(8, 8);
    BSTNode n7 = new BSTNode(7, 7, n5, n8);
    BSTNode root1 = new BSTNode(4, 4, n2, n7);

    BinarySearchTree tree1 = new BinarySearchTree();
    tree1.root = root1;

    assertEquals(4, tree1.delete(4));


        /*
                      5
                   /     \
                  2      7
                 / \   /   \
                1   3 6     8

         */
    BSTNode x1 = new BSTNode(1, 1);
    BSTNode x3 = new BSTNode(3, 3);
    BSTNode x2 = new BSTNode(2, 2, x1, x3);

    BSTNode x6 = new BSTNode(6, 6);
    BSTNode x8 = new BSTNode(8, 8);
    BSTNode x7 = new BSTNode(7, 7, x6, x8);
    BSTNode root2 = new BSTNode(5, 5, x2, x7);
    BinarySearchTree tree2 = new BinarySearchTree();
    tree2.root = root2;

    assertTrue(tree1.isSameTree(tree2));
  }

  @Test
  public void testRecursionDeleteNodeWithTwoChildren1() {
        /*
                      4
                   /     \
                  2      7
                 / \   /   \
                1   3 5     8
                       \
                        6
         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n3 = new BSTNode(3, 3);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n6 = new BSTNode(6, 6);
    BSTNode n5 = new BSTNode(5, 5, null, n6);
    BSTNode n8 = new BSTNode(8, 8);
    BSTNode n7 = new BSTNode(7, 7, n5, n8);
    BSTNode root1 = new BSTNode(4, 4, n2, n7);

    BinarySearchTree tree1 = new BinarySearchTree();
    tree1.root = root1;

    assertEquals(4, tree1.deleteByRecursion(4));


        /*
                      5
                   /     \
                  2      7
                 / \   /   \
                1   3 6     8

         */
    BSTNode x1 = new BSTNode(1, 1);
    BSTNode x3 = new BSTNode(3, 3);
    BSTNode x2 = new BSTNode(2, 2, x1, x3);

    BSTNode x6 = new BSTNode(6, 6);
    BSTNode x8 = new BSTNode(8, 8);
    BSTNode x7 = new BSTNode(7, 7, x6, x8);
    BSTNode root2 = new BSTNode(5, 5, x2, x7);
    BinarySearchTree tree2 = new BinarySearchTree();
    tree2.root = root2;

    assertTrue(tree1.isSameTree(tree2));
  }

  @Test
  public void testDeleteNodeWithTwoChildren2() {
    /*
                     4
                   /   \
                  2     5
                 / \     \
                1   3     6

         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n3 = new BSTNode(3, 3);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n6 = new BSTNode(6, 6);
    BSTNode n5 = new BSTNode(5, 5, null, n6);
    BSTNode root1 = new BSTNode(4, 4, n2, n5);

    BinarySearchTree tree1 = new BinarySearchTree();
    tree1.root = root1;

    assertEquals(4, tree1.delete(4));


        /*
                     5
                   /  \
                  2    6
                 / \
                1   3

         */
    BSTNode x1 = new BSTNode(1, 1);
    BSTNode x3 = new BSTNode(3, 3);
    BSTNode x2 = new BSTNode(2, 2, x1, x3);

    BSTNode x6 = new BSTNode(6, 6);
    BSTNode root2 = new BSTNode(5, 5, x2, x6);
    BinarySearchTree tree2 = new BinarySearchTree();
    tree2.root = root2;

    assertTrue(tree1.isSameTree(tree2));
  }

  @Test
  public void testRecursionDeleteNodeWithTwoChildren2() {
    /*
                     4
                   /   \
                  2     5
                 / \     \
                1   3     6

         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n3 = new BSTNode(3, 3);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n6 = new BSTNode(6, 6);
    BSTNode n5 = new BSTNode(5, 5, null, n6);
    BSTNode root1 = new BSTNode(4, 4, n2, n5);

    BinarySearchTree tree1 = new BinarySearchTree();
    tree1.root = root1;

    assertEquals(4, tree1.deleteByRecursion(4));


        /*
                     5
                   /  \
                  2    6
                 / \
                1   3

         */
    BSTNode x1 = new BSTNode(1, 1);
    BSTNode x3 = new BSTNode(3, 3);
    BSTNode x2 = new BSTNode(2, 2, x1, x3);

    BSTNode x6 = new BSTNode(6, 6);
    BSTNode root2 = new BSTNode(5, 5, x2, x6);
    BinarySearchTree tree2 = new BinarySearchTree();
    tree2.root = root2;

    assertTrue(tree1.isSameTree(tree2));
  }

  public BinarySearchTree createTree() {
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

    BinarySearchTree tree = new BinarySearchTree();
    tree.root = root;
    return tree;
  }
}
