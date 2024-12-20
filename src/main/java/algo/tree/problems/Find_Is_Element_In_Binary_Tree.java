package algo.tree.problems;

import algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Find_Is_Element_In_Binary_Tree {

  public static class Solution1 {

    public boolean isInBinaryTree(TreeNode root, int target) {
      if (root == null) {
        return false;
      }

      if (root.val == target) {
        return true;
      }

      return isInBinaryTree(root.left, target) || isInBinaryTree(root.right, target);
    }
  }

  public static class Solution2 {

    public boolean isInBinaryTree(TreeNode root, int target) {
      if (root == null) {
        return false;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while(!queue.isEmpty()) {
        TreeNode node = queue.poll();

        if (node.val == target) {
          return true;
        }

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      return false;
    }
  }
}
