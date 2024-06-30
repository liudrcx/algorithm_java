package liudrcx.problems.tree;

import liudrcx.algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Maximum_Depth_of_Binary_Tree_104 {

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
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
    }
  }

  class Solution2 {
    public int maxDepth(TreeNode root) {
      TreeNode curr = root;
      TreeNode pop = null;
      Stack<TreeNode> stack = new Stack<>();
      int max = 0;
      while(curr != null || !stack.isEmpty()) {
        if (curr != null) {
          stack.push(curr);
          if (max < stack.size()) {
            max = stack.size();
          }
          curr = curr.left;
        } else {
          TreeNode peek = stack.peek();
          if (peek.right == null || peek.right == pop) {
            pop = stack.pop();
          } else {
            curr = peek.right;
          }
        }
      }
      return max;
    }
  }

  class Solution3 {
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }

      int depth = 0;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()) {
        int size = queue.size();
        for(int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          if (node.left != null) {
            queue.offer(node.left);
          }
          if (node.right != null) {
            queue.offer(node.right);
          }
        }
        depth++;
      }
      return depth;
    }
  }
}
