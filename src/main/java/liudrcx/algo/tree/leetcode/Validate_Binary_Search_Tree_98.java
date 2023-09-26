package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 */
public class Validate_Binary_Search_Tree_98 {

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
    public boolean isValidBST(TreeNode root) {
      if (root == null) {
        return true;
      }

      TreeNode node = root;
      Stack<TreeNode> stack = new Stack<>();
      long prev = Long.MIN_VALUE;

      while(node != null || !stack.isEmpty()) {
        if (node != null) {
          stack.push(node);
          node = node.left;
        } else {
          TreeNode pop = stack.pop();
          if (prev >= pop.val) {
            return false;
          }
          prev = pop.val;
          node = pop.right;
        }
      }

      return true;
    }
  }

  class Solution2 {

    long prev = Long.MIN_VALUE;

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
      } else {
        prev = root.val;
      }

      boolean right = isValidBST(root.right);
      return right;
    }
  }

  class Solution3 {

    public boolean isValidBST(TreeNode root) {
      return doValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doValid(TreeNode node, long min, long max) {
      if (node == null) {
        return true;
      }

      if (node.val <= min || node.val >= max) {
        return false;
      }

      return doValid(node.left, min, node.val) && doValid(node.right, node.val, max);
    }

  }

}
