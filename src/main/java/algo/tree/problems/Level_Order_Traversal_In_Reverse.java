package algo.tree.problems;

import algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Level_Order_Traversal_In_Reverse {

  public static class Solution1 {
    public List<Integer> traverse(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      Stack<Integer> stack = new Stack<>();

      while(!queue.isEmpty()) {
        TreeNode node = queue.poll();
        stack.push(node.val);

        if (node.right != null) {
          queue.offer(node.right);
        }

        if (node.left != null) {
          queue.offer(node.left);
        }
      }

      while (!stack.isEmpty()) {
        result.add(stack.pop());
      }

      return result;
    }
  }
}
