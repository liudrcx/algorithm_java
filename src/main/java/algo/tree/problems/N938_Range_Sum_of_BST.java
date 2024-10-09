package algo.tree.problems;

import algo.tree.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/range-sum-of-bst/description/
 *
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
public class N938_Range_Sum_of_BST {

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

      int result = 0;

      Stack<TreeNode> stack = new Stack<>();
      TreeNode currentNode = root;

      while(currentNode != null || !stack.isEmpty()) {
        if (currentNode != null) {
          stack.push(currentNode);
          currentNode = currentNode.left;
        } else {
          TreeNode popNode = stack.pop();
          if (popNode.val > high) {
            break;
          }

          if (popNode.val >= low) {
            result += popNode.val;
          }

          currentNode = popNode.right;
        }
      }

      return result;
    }
  }

  class Solution2 {
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

      return rangeSumBST(root.left, low, high)
        + root.val
        + rangeSumBST(root.right, low, high);
    }
  }
}
