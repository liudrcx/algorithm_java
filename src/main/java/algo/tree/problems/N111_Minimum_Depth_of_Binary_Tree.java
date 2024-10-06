package algo.tree.problems;

import algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class N111_Minimum_Depth_of_Binary_Tree {

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode() {}
   *     TreeNode(int val) { this.val = val; }
   *     TreeNode(int val, TreeNode left, TreeNode right) {
   *         this.val = val;
   *         this.left = left;
   *         this.right = right;
   *     }
   * }
   */
  class Solution1 {
    public int minDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }

      int leftDepth = minDepth(root.left);
      int rightDepth = minDepth(root.right);

      if (leftDepth == 0) {
        return rightDepth + 1;
      }

      if (rightDepth == 0) {
        return leftDepth + 1;
      }

      return 1 + Integer.min(leftDepth, rightDepth);
    }
  }

  /**
   * using level iteration, the depth of first leaf node is the min depth
   */
  class Solution2 {
    public int minDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }

      int minDepth = 0;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while(!queue.isEmpty()) {
        minDepth++;

        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          if (node.left == null && node.right == null) {
            return minDepth;
          }

          if (node.left != null) {
            queue.offer(node.left);
          }

          if (node.right != null) {
            queue.offer(node.right);
          }
        }
      }

      return minDepth;
    }
  }
}
