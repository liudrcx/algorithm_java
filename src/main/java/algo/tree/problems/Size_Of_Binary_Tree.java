package algo.tree.problems;

import algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Size_Of_Binary_Tree {

  public static class Solution1 {

    public int size(TreeNode root) {
      if (root == null) {
        return 0;
      }

      return 1 + size(root.left) + size(root.right);
    }
  }

  public static class Solution2 {

    public int size(TreeNode root) {
      int size = 0;

      if (root != null) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
          TreeNode node = queue.poll();
          size++;

          if (node.left != null) {
            queue.offer(node.left);
          }

          if (node.right != null) {
            queue.offer(node.right);
          }
        }
      }

      return size;
    }
  }
}
