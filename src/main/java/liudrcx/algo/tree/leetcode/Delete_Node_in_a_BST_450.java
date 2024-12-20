package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class Delete_Node_in_a_BST_450 {

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
    public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) {
        return null;
      }

      if (key < root.val) {
        root.left = deleteNode(root.left, key);
        return root;
      }

      if (root.val < key) {
        root.right = deleteNode(root.right, key);
        return root;
      }

      if (root.left == null) {
        return root.right;
      }

      if (root.right == null) {
        return root.left;
      }

      TreeNode s = root.right;
      while(s.left != null) {
        s = s.left;
      }

      s.right = deleteNode(root.right, s.val);
      s.left = root.left;

      return s;
    }
  }
}













