package algo.tree.problems;

import algo.tree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static algo.tree.problems.Find_Is_Element_In_Binary_Tree.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Find_Is_Element_In_Binary_Tree_Test {

  @Test
  public void testSolution1() {
    TreeNode root =
      new TreeNode(
        5,
        new TreeNode(
          3,
          new TreeNode(10),
          new TreeNode(12)
        ),
        new TreeNode(
          7,
          null,
          new TreeNode(9)
        )
      );

    Solution1 solution1 = new Solution1();
    assertTrue(solution1.isInBinaryTree(root, 10));
    assertFalse(solution1.isInBinaryTree(root, 88));
  }

  @Test
  public void testSolution2() {
    TreeNode root =
      new TreeNode(
        5,
        new TreeNode(
          3,
          new TreeNode(10),
          new TreeNode(12)
        ),
        new TreeNode(
          7,
          null,
          new TreeNode(9)
        )
      );

    Solution2 solution2 = new Solution2();
    assertTrue(solution2.isInBinaryTree(root, 10));
    assertFalse(solution2.isInBinaryTree(root, 88));
  }
}
