package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/path-sum-iii/description/
 */
public class Path_Sum_III_437 {

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
    public int pathSum(TreeNode root, int targetSum) {
      if (root == null) {
        return 0;
      }
      return pathSumWithRoot(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int pathSumWithRoot(TreeNode root, long targetSum) {
      if (root == null) {
        return 0;
      }

      int ret = 0;
      if (root.val == targetSum) {
        ret += 1;
      }
      ret += (pathSumWithRoot(root.left, targetSum - root.val) + pathSumWithRoot(root.right, targetSum - root.val));
      return ret;
    }
  }
}
