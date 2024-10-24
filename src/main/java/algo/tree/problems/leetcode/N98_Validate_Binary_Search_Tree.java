package algo.tree.problems.leetcode;

import algo.tree.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 */
public class N98_Validate_Binary_Search_Tree {

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

  //using middle iteration
  class Solution1 {
    public boolean isValidBST(TreeNode root) {
      if (root == null) {
        return true;
      }

      Stack<TreeNode> stack = new Stack<>();
      TreeNode currentNode = root;
      long prev = Long.MIN_VALUE;

      while(currentNode != null || !stack.isEmpty()) {
        if (currentNode != null) {
          stack.push(currentNode);
          currentNode = currentNode.left;
        } else {
          TreeNode popNode = stack.pop();
          if (prev >= popNode.val) {
            return false;
          }

          prev = popNode.val;
          currentNode = popNode.right;
        }
      }

      return true;
    }
  }

  class Solution2 {

    private long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
      if (root == null) {
        return true;
      }

      boolean left = isValidBST(root.left);
      if (!left) {
        return false;
      }

      if (prev >= root.val) {
        return false;
      }

      prev = root.val;

      return isValidBST(root.right);
    }
  }

  class Solution3 {

    public boolean isValidBST(TreeNode root) {
      return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
      if (root == null) {
        return true;
      }

      if (root.val <= min || root.val >= max) {
        return false;
      }

      return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

  }
}
