package liudrcx.problems.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionTree {

  public static TreeNode constructExpressionTree(String[] tokens) {
    Stack<TreeNode> stack = new Stack<>();
    for(String token : tokens) {
      switch (token) {
        case "+", "-", "*", "/" -> {
          TreeNode right = stack.pop();
          TreeNode left = stack.pop();
          TreeNode parent = new TreeNode(token);
          parent.left = left;
          parent.right = right;
          stack.push(parent);
        }
        default -> {
          stack.push(new TreeNode(token));
        }
      }
    }
    return stack.peek();
  }

  public static List<String> postTraverse(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    result.addAll(postTraverse(root.left));
    result.addAll(postTraverse(root.right));
    result.add(root.value);
    return result;
  }

  public static class TreeNode {
    public String value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String value) {
      this.value = value;
    }
  }
}
