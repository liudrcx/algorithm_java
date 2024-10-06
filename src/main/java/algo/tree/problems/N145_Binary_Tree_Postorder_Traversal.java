package algo.tree.problems;

import algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 */
public class N145_Binary_Tree_Postorder_Traversal {

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

      Stack<TreeNode> stack = new Stack<>();
      TreeNode current = root;
      TreeNode popNode = null;

      while(current != null || !stack.isEmpty()) {
        if (current != null) {
          stack.push(current);
          current = current.left;
        } else {
          TreeNode topNode = stack.peek();
          if (topNode.right == null || topNode.right == popNode) {
            popNode = stack.pop();
            result.add(popNode.val);
          } else {
            current = topNode.right;
          }
        }
      }

      return result;
    }
  }
}
