package algo.tree.problems;

import algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class N235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */

  class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      TreeNode currentNode = root;

      while(currentNode != null && (currentNode.val < p.val && currentNode.val < q.val
        || currentNode.val > p.val && currentNode.val > q.val)) {
        if (currentNode.val > p.val) {
          currentNode = currentNode.left;
        } else {
          currentNode = currentNode.right;
        }
      }
      return currentNode;
    }
  }
}
