package liudrcx.algo.queue.leetcode;

import liudrcx.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Binary_Tree_Level_Order_Traversal_102 {

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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while(! queue.isEmpty()) {
        int size = queue.size();
        List<Integer> levels = new ArrayList<>(size);
        result.add(levels);

        for(int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          levels.add(node.val);

          TreeNode left = node.left;
          if (left != null) {
            queue.offer(left);
          }

          TreeNode right = node.right;
          if (right != null) {
            queue.offer(right);
          }
        }
      }
      return result;
    }
  }
}
