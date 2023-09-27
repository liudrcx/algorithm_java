package liudrcx.algo.tree.leetcode;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */

import liudrcx.algo.tree.TreeNode;

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
public class Construct_Binary_Search_Tree_from_Preorder_Traversal_1008 {

  class Solution1 {
    public TreeNode bstFromPreorder(int[] preorder) {
      TreeNode root = insert(null, preorder[0]);
      for(int i = 1; i < preorder.length; i++) {
        insert(root, preorder[i]);
      }

      return root;
    }

    private TreeNode insert(TreeNode node, int val) {
      if (node == null) {
        return new TreeNode(val);
      }

      if (val < node.val) {
        node.left = insert(node.left, val);
      } else {
        node.right = insert(node.right, val);
      }

      return node;
    }
  }

  class Solution2 {
    public TreeNode bstFromPreorder(int[] preorder) {
      return insert(preorder, Integer.MAX_VALUE);
    }

    int index = 0;
    private TreeNode insert(int[] preorder, int max) {
      if (index == preorder.length) {
        return null;
      }

      int val = preorder[index];
      if (val > max) {
        return null;
      }

      TreeNode node = new TreeNode(val);
      index++;
      node.left = insert(preorder, node.val);
      node.right = insert(preorder, max);

      return node;
    }
  }

  class Solution3 {
    public TreeNode bstFromPreorder(int[] preorder) {
      return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
      if (start > end) {
        return null;
      }

      int index = start + 1;
      while(index <= end) {
        if (preorder[index] > preorder[start]) {
          break;
        }
        index++;
      }

      TreeNode node = new TreeNode(preorder[start]);
      node.left = bstFromPreorder(preorder, start + 1, index - 1);
      node.right = bstFromPreorder(preorder, index, end);

      return node;
    }
  }
}
