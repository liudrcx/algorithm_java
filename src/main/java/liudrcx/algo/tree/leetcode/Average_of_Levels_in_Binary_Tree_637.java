package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 */
public class Average_of_Levels_in_Binary_Tree_637 {

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
    public List<Double> averageOfLevels(TreeNode root) {
      List<Double> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while(! queue.isEmpty()) {
        double levelSum = 0;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          levelSum += node.val;

          if (node.left != null) {
            queue.offer(node.left);
          }

          if (node.right != null) {
            queue.offer(node.right);
          }
        }

        result.add(levelSum / size);
      }

      return result;
    }
  }
}










