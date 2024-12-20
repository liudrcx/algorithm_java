package algo.tree.problems;

import algo.tree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static algo.tree.problems.Level_Order_Traversal_In_Reverse.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class Level_Order_Traversal_In_Reverse_Test {

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
    List<Integer> result = solution.traverse(root);
    assertIterableEquals(List.of(10, 12, 9, 3, 7, 5), result);
  }
}
