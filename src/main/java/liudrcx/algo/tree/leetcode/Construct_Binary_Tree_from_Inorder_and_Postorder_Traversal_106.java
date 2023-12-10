package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      if (inorder == null || inorder.length ==0 || postorder == null || postorder.length ==0) {
        return null;
      }

      Map<Integer, Integer> inorderIndexMap = new HashMap<>();
      for (int i = 0; i < inorder.length; i++) {
        inorderIndexMap.put(inorder[i], i);
      }

      return buildTree(
          inorder,
          0,
          inorder.length - 1,
          postorder,
          0,
          postorder.length - 1,
          inorderIndexMap
      );
    }

    private TreeNode buildTree(int[] inorder,
                               int inStart,
                               int inEnd,
                               int[] postorder,
                               int postStart,
                               int postEnd,
                               Map<Integer, Integer> inorderIndexMap) {
      if (inStart > inEnd || postStart > postEnd) {
        return null;
      }

      int rootVal = postorder[postEnd];
      int rootIndex = inorderIndexMap.get(rootVal);
      int leftSize = rootIndex - inStart;

      TreeNode root = new TreeNode(rootVal);

      root.left = buildTree(
          inorder,
          inStart,
          rootIndex - 1,
          postorder,
          postStart,
          postStart + leftSize -1,
          inorderIndexMap
      );

      root.right = buildTree(
          inorder,
          rootIndex + 1,
          inEnd,
          postorder,
          postStart + leftSize,
          postEnd - 1,
          inorderIndexMap
      );

      return root;
    }
  }
}
