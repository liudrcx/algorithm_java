package algo.tree.problems;

import algo.tree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static algo.tree.problems.Find_Max_Node_In_Binary_Tree.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Find_Max_Node_In_Binary_Tree_Test {

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

    int max = new Solution1().findMax(root);
    assertEquals(12, max);
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

    int max = new Solution2().findMax(root);
    assertEquals(12, max);
  }


}
