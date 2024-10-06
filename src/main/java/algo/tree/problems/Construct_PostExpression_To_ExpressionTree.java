package algo.tree.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Construct_PostExpression_To_ExpressionTree {

  public static TreeNode construct(String[] expr) {
    if (expr == null || expr.length == 0) {
      return null;
    }

    Stack<TreeNode> stack = new Stack<>();
    for(String s : expr) {
      switch (s) {
        case "+", "-", "*", "/" -> {
          TreeNode right = stack.pop();
          TreeNode left = stack.pop();

          TreeNode parent = new TreeNode(s);
          parent.left = left;
          parent.right = right;

          stack.push(parent);
        }
        default -> {
          TreeNode node = new TreeNode(s);
          stack.push(node);
        }
      }
    }

    return stack.peek();
  }

  public static List<String> postIteration(TreeNode root) {
    List<String> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    result.addAll(postIteration(root.left));
    result.addAll(postIteration(root.right));
    result.add(root.val);

    return result;
  }

  public static class TreeNode {

    String val;

    TreeNode left;

    TreeNode right;


    public TreeNode(String val) {
      this.val = val;
    }

    public TreeNode(String val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
