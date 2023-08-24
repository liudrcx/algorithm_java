package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class Minimum_Depth_of_Binary_Tree_111 {

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

      int d1 = minDepth(root.left);
      int d2 = minDepth(root.right);
      if (d1 == 0 || d2 == 0) {
        return d1 + d2 + 1;
      }
      return 1 + Integer.min(d1, d2);
    }
  }

  class Solution2 {
    public int minDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      int depth = 0;
      while(!queue.isEmpty()) {
        depth++;
        int size = queue.size();
        for(int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          if (node.left == null && node.right == null) {
            return depth;
          }

          if (node.left != null) {
            queue.offer(node.left);
          }

          if (node.right != null) {
            queue.offer(node.right);
          }
        }
      }

      return depth;
    }
  }
}
