package algo.tree.problems;

import algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 *
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 */
public class N700_Search_in_a_Binary_Search_Tree {

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
      TreeNode currentNode = root;

      while(currentNode != null) {
        if (val < currentNode.val) {
          currentNode = currentNode.left;
        } else if (currentNode.val < val) {
          currentNode = currentNode.right;
        } else {
          return currentNode;
        }
      }
      return null;
    }
  }
}
