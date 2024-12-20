package algo.tree.problems;

import algo.tree.TreeNode;
import org.junit.jupiter.api.Test;

import static algo.tree.problems.Insert_Element_Into_Binary_Tree.Solution1;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Insert_Element_Into_Binary_Tree_Test {

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
    solution.insert(root, 16);

    assertTrue(root.isSameTree(
      new TreeNode(
        5,
        new TreeNode(
          3,
          new TreeNode(10),
          new TreeNode(12)
        ),
        new TreeNode(
          7,
          new TreeNode(16),
          new TreeNode(9)
        )
      )
    ));
  }
}
