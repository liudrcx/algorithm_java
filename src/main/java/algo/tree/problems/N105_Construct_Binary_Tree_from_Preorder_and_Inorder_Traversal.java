package algo.tree.problems;

import algo.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class N105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder == null || preorder.length == 0 || inorder == null || inorder.length ==0) {
        return null;
      }

      Map<Integer, Integer> inOrderToIndexMap = new HashMap<>();
      for (int i = 0; i < inorder.length; i++) {
        inOrderToIndexMap.put(inorder[i], i);
      }

      return buildTree(
        preorder,
        0,
        preorder.length - 1,
        inorder,
        0,
        inorder.length - 1,
        inOrderToIndexMap
      );
    }

    private TreeNode buildTree(
      int[] preorder,
      int preStart,
      int preEnd,
      int[] inorder,
      int inStart,
      int inEnd,
      Map<Integer, Integer> inOrderToIndexMap
    ) {
      if (preStart > preEnd || inStart > inEnd) {
        return null;
      }

      int rootVal = preorder[preStart];
      int index = inOrderToIndexMap.get(rootVal);
      int leftCount = index - inStart;

      TreeNode root = new TreeNode(rootVal);

      root.left =
        buildTree(
          preorder,
          preStart + 1,
          preStart + leftCount,
          inorder,
          inStart,
          index - 1,
          inOrderToIndexMap
        );

      root.right =
        buildTree(
          preorder,
        preStart + leftCount + 1,
        preEnd,
        inorder,
        index + 1,
        inEnd,
        inOrderToIndexMap
        );

      return root;
    }
  }
}
