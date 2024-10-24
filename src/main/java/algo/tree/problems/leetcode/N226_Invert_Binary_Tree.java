package algo.tree.problems.leetcode;

import algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class N226_Invert_Binary_Tree {

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
  class Solution {
    public TreeNode invertTree(TreeNode root) {
      invert(root);
      return root;
    }

    private void invert(TreeNode root) {
      if (root == null) {
        return;
      }

      TreeNode leftNode = root.left;
      root.left = root.right;
      root.right = leftNode;

      invert(root.left);
      invert(root.right);
    }
  }
}
