package algo.tree.problems;

import algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 *
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 */
public class N701_Insert_into_a_Binary_Search_Tree {

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
      TreeNode currentNode = root;
      TreeNode parentNode = null;

      while(currentNode != null) {
        parentNode = currentNode;
        if (val < currentNode.val) {
          currentNode = currentNode.left;
        } else {
          currentNode = currentNode.right;
        }
      }

      if (parentNode == null) {
        return new TreeNode(val);
      } else if (val < parentNode.val) {
        parentNode.left = new TreeNode(val);
      } else {
        parentNode.right = new TreeNode(val);
      }

      return root;
    }
  }
}
