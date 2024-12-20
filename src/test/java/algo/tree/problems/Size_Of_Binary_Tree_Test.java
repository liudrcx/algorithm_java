package algo.tree.problems;

import algo.tree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static algo.tree.problems.Size_Of_Binary_Tree.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Size_Of_Binary_Tree_Test {

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

    Solution1 solution = new Solution1();
    int size = solution.size(root);
    assertEquals(6, size);
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

    Solution2 solution = new Solution2();
    int size = solution.size(root);
    assertEquals(6, size);
  }
}
