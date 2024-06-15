package liudrcx.problems.tree;

import liudrcx.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class Binary_Tree_Preorder_Traversal_144 {

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
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      result.add(root.val);
      result.addAll(preorderTraversal(root.left));
      result.addAll(preorderTraversal(root.right));

      return result;
    }
  }

  class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      TreeNode curr = root;
      Stack<TreeNode> stack = new Stack<>();
      while(curr != null || !stack.isEmpty()) {
        if (curr != null) {
          result.add(curr.val);
          stack.push(curr);
          curr = curr.left;
        } else {
          TreeNode p = stack.pop();
          curr = p.right;
        }
      }

      return result;
    }
  }

}
