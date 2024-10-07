package algo.tree.problems;

import algo.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 */
public class N106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

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
      if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
        return null;
      }

      Map<Integer, Integer> inorderToIndexMap = new HashMap<>();
      for (int i = 0; i < inorder.length; i++) {
        inorderToIndexMap.put(inorder[i], i);
      }

      return buildTree(
        inorder,
        0,
        inorder.length - 1,
        postorder,
        0,
        postorder.length - 1,
        inorderToIndexMap
      );
    }

    private TreeNode buildTree(
      int[] inorder,
      int inStart,
      int inEnd,
      int[] postorder,
      int postStart,
      int postEnd,
      Map<Integer, Integer> inorderToIndexMap
    ) {
      if (inStart > inEnd || postStart > postEnd) {
        return null;
      }

      int rootVal = postorder[postEnd];
      int index = inorderToIndexMap.get(rootVal);
      int leftCount = index - inStart;

      TreeNode root = new TreeNode(rootVal);

      root.left =
        buildTree(
          inorder,
          inStart,
          index - 1,
          postorder,
          postStart,
          postStart + leftCount - 1,
          inorderToIndexMap
        );

      root.right =
        buildTree(
          inorder,
          index + 1,
          inEnd,
          postorder,
          postStart + leftCount,
          postEnd - 1,
          inorderToIndexMap
        );

      return root;
    }
  }
}
