package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/range-sum-of-bst/description/
 *
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
public class Range_Sum_of_BST_938 {

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
    public int rangeSumBST(TreeNode root, int low, int high) {
      if (root == null) {
        return 0;
      }

      if (root.val < low) {
        return rangeSumBST(root.right, low, high);
      }

      if (root.val > high) {
        return rangeSumBST(root.left, low, high);
      }

      return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

  }

  class Solution2 {
    public int rangeSumBST(TreeNode root, int low, int high) {
      if (root == null) {
        return 0;
      }

      int sum = 0;
      TreeNode node = root;
      Stack<TreeNode> stack = new Stack<>();
      while(node != null || !stack.isEmpty()) {
        if (node != null) {
          stack.push(node);
          node = node.left;
        } else {
          TreeNode pop = stack.pop();

          if (pop.val > high) {
            break;
          }

          if (pop.val >= low) {
            sum += pop.val;
          }

          node = pop.right;
        }
      }

      return sum;
    }
  }

  class Solution3 {

    public int rangeSumBST(TreeNode root, int low, int high) {
      if (root == null) {
        return 0;
      }

      int leftSum = rangeSumBST(root.left, low, high);
      int currVal = root.val >= low && root.val <= high ? root.val : 0;
      return leftSum + currVal + rangeSumBST(root.right,low, high);
    }
  }

}
