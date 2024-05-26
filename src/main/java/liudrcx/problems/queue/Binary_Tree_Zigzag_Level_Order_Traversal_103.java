package liudrcx.problems.queue;

import liudrcx.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      boolean odd = true;
      while(! queue.isEmpty()) {
        int size = queue.size();
        LinkedList<Integer> levels = new LinkedList<>();
        result.add(levels);
        for(int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          if (odd) {
            levels.offerLast(node.val);
          } else {
            levels.offerFirst(node.val);
          }

          if (node.left != null) {
            queue.offer(node.left);
          }

          if (node.right != null) {
            queue.offer(node.right);
          }
        }
        odd = !odd;
      }
      return result;
    }
  }
}
