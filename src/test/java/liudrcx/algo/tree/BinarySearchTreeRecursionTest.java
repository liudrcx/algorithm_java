package liudrcx.algo.tree;

import liudrcx.algo.tree.BinarySearchTreeRecursion.BSTNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeRecursionTest {

  @Test
  public void testGet() {
    BinarySearchTreeRecursion tree = createTree();
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
    BinarySearchTreeRecursion tree = createTree();
    assertEquals("张无忌", tree.min());
    assertEquals("殷离", tree.max());
  }

  @Test
  public void testPut() {
    BinarySearchTreeRecursion tree = new BinarySearchTreeRecursion();
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

    BinarySearchTreeRecursion tree1 = new BinarySearchTreeRecursion();
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
    BinarySearchTreeRecursion tree2 = new BinarySearchTreeRecursion();
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

    BinarySearchTreeRecursion tree1 = new BinarySearchTreeRecursion();
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
    BinarySearchTreeRecursion tree2 = new BinarySearchTreeRecursion();
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

    BinarySearchTreeRecursion tree1 = new BinarySearchTreeRecursion();
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
    BinarySearchTreeRecursion tree2 = new BinarySearchTreeRecursion();
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

    BinarySearchTreeRecursion tree1 = new BinarySearchTreeRecursion();
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
    BinarySearchTreeRecursion tree2 = new BinarySearchTreeRecursion();
    tree2.root = root2;

    assertTrue(tree1.isSameTree(tree2));
  }

  @Test
  public void testLess() {
        /*
                 4
               /   \
              2     6
             / \   / \
            1   3 5   7
         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n3 = new BSTNode(3, 3);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n5 = new BSTNode(5, 5);
    BSTNode n7 = new BSTNode(7, 7);
    BSTNode n6 = new BSTNode(6, 6, n5, n7);
    BSTNode root = new BSTNode(4, 4, n2, n6);

    BinarySearchTreeRecursion tree = new BinarySearchTreeRecursion();
    tree.root = root;

    assertIterableEquals(List.of(1, 2, 3, 4, 5), tree.less(6));
  }

  @Test
  public void testGreater() {
        /*
                 4
               /   \
              2     6
             / \   / \
            1   3 5   7
         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n3 = new BSTNode(3, 3);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n5 = new BSTNode(5, 5);
    BSTNode n7 = new BSTNode(7, 7);
    BSTNode n6 = new BSTNode(6, 6, n5, n7);
    BSTNode root = new BSTNode(4, 4, n2, n6);

    BinarySearchTreeRecursion tree = new BinarySearchTreeRecursion();
    tree.root = root;

    assertIterableEquals(List.of(7), tree.greater(6));
    assertIterableEquals(List.of(6, 7), tree.greater(5));
  }

  @Test
  public void testBetween() {
        /*
                 4
               /   \
              2     6
             / \   / \
            1   3 5   7
         */
    BSTNode n1 = new BSTNode(1, 1);
    BSTNode n3 = new BSTNode(3, 3);
    BSTNode n2 = new BSTNode(2, 2, n1, n3);

    BSTNode n5 = new BSTNode(5, 5);
    BSTNode n7 = new BSTNode(7, 7);
    BSTNode n6 = new BSTNode(6, 6, n5, n7);
    BSTNode root = new BSTNode(4, 4, n2, n6);

    BinarySearchTreeRecursion tree = new BinarySearchTreeRecursion();
    tree.root = root;

    assertIterableEquals(List.of(3, 4, 5), tree.between(3, 5));
  }

  public BinarySearchTreeRecursion createTree() {
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

    BinarySearchTreeRecursion tree = new BinarySearchTreeRecursion();
    tree.root = root;

    return tree;
  }
}
