package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class Insert_into_a_Binary_Search_Tree_701 {

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
      if (root == null) {
        return new TreeNode(val);
      }

      if (val < root.val) {
        root.left = insertIntoBST(root.left, val);
      } else {
        root.right = insertIntoBST(root.right, val);
      }

      return root;
    }
  }
}

















