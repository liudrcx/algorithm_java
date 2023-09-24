package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class Search_in_a_Binary_Search_Tree_700 {

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
    public TreeNode searchBST(TreeNode root, int val) {
      if (root == null) {
        return null;
      }

      if (val < root.val) {
        return searchBST(root.left, val);
      } else if(root.val < val){
        return searchBST(root.right, val);
      } else {
        return root;
      }
    }
  }
}
