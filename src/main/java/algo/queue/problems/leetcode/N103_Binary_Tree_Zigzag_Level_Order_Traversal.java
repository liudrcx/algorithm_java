package algo.queue.problems.leetcode;

import algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 */
public class N103_Binary_Tree_Zigzag_Level_Order_Traversal {

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

      while(!queue.isEmpty()) {
        LinkedList<Integer> levelList = new LinkedList<>();
        result.add(levelList);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();

          if (odd) {
            levelList.offerLast(node.val);
          } else {
            levelList.offerFirst(node.val);
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
