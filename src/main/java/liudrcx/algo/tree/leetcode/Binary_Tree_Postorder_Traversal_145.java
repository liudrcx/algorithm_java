package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class Binary_Tree_Postorder_Traversal_145 {

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
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      result.addAll(postorderTraversal(root.left));
      result.addAll(postorderTraversal(root.right));
      result.add(root.val);
      return result;
    }
  }

  class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      TreeNode curr = root;
      TreeNode pop = null;
      Stack<TreeNode> stack = new Stack<>();
      while(curr != null || !stack.isEmpty()) {
        if (curr != null) {
          stack.push(curr);
          curr = curr.left;
        } else {
          TreeNode peek = stack.peek();
          if (peek.right == null || peek.right == pop) {
            pop = stack.pop();
            result.add(pop.val);
          } else {
            curr = peek.right;
          }
        }
      }
      return result;
    }
  }
}
