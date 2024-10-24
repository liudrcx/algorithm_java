package algo.tree.problems.leetcode;

import algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class N94_Binary_Tree_Inorder_Traversal {

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

      Stack<TreeNode> stack = new Stack<>();
      TreeNode current = root;

      while(current != null || !stack.isEmpty()) {
        if (current != null) {
          stack.push(current);
          current = current.left;
        } else {
          TreeNode popNode = stack.pop();
          result.add(popNode.val);
          current = popNode.right;
        }
      }

      return result;
    }
  }

}
