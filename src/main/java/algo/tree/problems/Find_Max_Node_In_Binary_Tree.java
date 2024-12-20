package algo.tree.problems;

import algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.MIN_VALUE;

public class Find_Max_Node_In_Binary_Tree {

  public static class Solution1 {

    public int findMax(TreeNode root) {
      int max = MIN_VALUE;

      if (root != null) {
        max = root.val;

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        if (max < leftMax) {
          max = leftMax;
        }

        if (max < rightMax) {
          max = rightMax;
        }
      }
      return max;
    }
  }

  public static class Solution2 {

    public int findMax(TreeNode root) {
      int max = MIN_VALUE;

      if (root == null) {
        return max;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while(!queue.isEmpty()) {
        TreeNode node = queue.poll();

        if (max < node.val) {
          max = node.val;
        }

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      return max;
    }

  }
}
