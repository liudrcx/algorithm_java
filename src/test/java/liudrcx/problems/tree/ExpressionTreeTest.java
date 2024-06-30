package liudrcx.problems.tree;

import org.junit.jupiter.api.Test;

import static liudrcx.problems.tree.ExpressionTree.constructExpressionTree;
import static liudrcx.problems.tree.ExpressionTree.postTraverse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExpressionTreeTest {

  @Test
  void test1() {
    String[] tokens = {"2", "1", "-", "3", "*"};
    ExpressionTree.TreeNode root = constructExpressionTree(tokens);
    assertArrayEquals(tokens, postTraverse(root).toArray(new String[0]));
  }

  @Test
  void test2() {
    String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    ExpressionTree.TreeNode root = constructExpressionTree(tokens);
    assertArrayEquals(tokens, postTraverse(root).toArray(new String[0]));
  }
}
