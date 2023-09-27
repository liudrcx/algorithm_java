package liudrcx.algo.tree.leetcode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */

import liudrcx.algo.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {

  class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) {
        return null;
      }

      if ((root.val > p.val && root.val > q.val)
          || (root.val < p.val && root.val < q.val)) {
        if (root.val > p.val) {
          return lowestCommonAncestor(root.left, p, q);
        } else {
          return lowestCommonAncestor(root.right, p, q);
        }
      }

      return root;
    }
  }

  class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      TreeNode node = root;

      while(node != null
          && (node.val > p.val && node.val > q.val)
            || (node.val < p.val && node.val < q.val)
      ) {
        if (node.val > p.val) {
          node = node.left;
        } else {
          node = node.right;
        }
      }

      return node;
    }

  }
}
