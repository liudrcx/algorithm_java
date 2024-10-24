package algo.tree.problems.leetcode;

import algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class N104_Maximum_Depth_of_Binary_Tree {

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

      int leftDepth = maxDepth(root.left);
      int rightDepth = maxDepth(root.right);

      return Integer.max(leftDepth, rightDepth) + 1;
    }
  }


  /**
   * using binary tree postorder iteration, the max length of stack is the max depth
   */
  class Solution2 {
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }

      int maxDepth = 0;

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
            int size = stack.size();
            if (maxDepth < size) {
              maxDepth = size;
            }
            popNode = stack.pop();
          } else {
            current = topNode.right;
          }
        }
      }

      return maxDepth;
    }
  }

  /**
   * using binary tree level iteration
   */
  class Solution3 {
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }

      int maxDepth = 0;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while(!queue.isEmpty()) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();

          if (node.left != null) {
            queue.offer(node.left);
          }

          if (node.right != null) {
            queue.offer(node.right);
          }
        }

        maxDepth++;
      }

      return maxDepth;
    }
  }
}
