package liudrcx.problems.tree;

import liudrcx.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class Binary_Tree_Inorder_Traversal_94 {

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
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      result.addAll(inorderTraversal(root.left));
      result.add(root.val);
      result.addAll(inorderTraversal(root.right));

      return result;
    }
  }

  class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      TreeNode curr = root;
      Stack<TreeNode> stack = new Stack<>();
      while(curr != null || !stack.isEmpty()) {
        if (curr != null) {
          stack.push(curr);
          curr = curr.left;
        } else {
          TreeNode p = stack.pop();
          result.add(p.val);
          curr = p.right;
        }
      }

      return result;
    }
  }
}
