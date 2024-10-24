package algo.tree.problems.leetcode;

import algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class N144_Binary_Tree_Preorder_Traversal {

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

      Stack<TreeNode> stack = new Stack<>();
      TreeNode current = root;
      while(current != null || !stack.isEmpty()) {
        if (current != null) {
          result.add(current.val);
          stack.push(current);
          current = current.left;
        } else {
          TreeNode popNode = stack.pop();
          current = popNode.right;
        }
      }

      return result;
    }
  }


}
