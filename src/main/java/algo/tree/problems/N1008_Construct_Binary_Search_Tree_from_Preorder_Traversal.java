package algo.tree.problems;

import algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
 *
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
 *
 * It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
 *
 * A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
 *
 * A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 */
public class N1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {

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
    public TreeNode bstFromPreorder(int[] preorder) {
      TreeNode root = new TreeNode(preorder[0]);
      for (int i = 1; i < preorder.length; i++) {
        insert(root, preorder[i]);
      }
      return root;
    }

    private void insert(TreeNode root, int val) {
      TreeNode currentNode = root;
      TreeNode parentNode = null;
      while(currentNode != null) {
        parentNode = currentNode;
        if (val < currentNode.val) {
          currentNode = currentNode.left;
        } else {
          currentNode = currentNode.right;
        }
      }

      if (parentNode == null) {
        return;
      }

      if (val < parentNode.val) {
        parentNode.left = new TreeNode(val);
      } else {
        parentNode.right = new TreeNode(val);
      }
    }
  }

  class Solution2 {
    public TreeNode bstFromPreorder(int[] preorder) {
      return insert(preorder, Integer.MAX_VALUE);
    }

    int i = 0;
    private TreeNode insert(int[] preorder, int max) {
      if (i == preorder.length) {
        return null;
      }

      int val = preorder[i];

      if (val > max) {
        return null;
      }

      i++;

      TreeNode node = new TreeNode(val);
      node.left = insert(preorder, val);
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

      int val = preorder[start];
      TreeNode root = new TreeNode(val);

      int index = start + 1;
      while (index <= end) {
        if (preorder[index] > preorder[start]) {
          break;
        }
        index++;
      }

      root.left = bstFromPreorder(preorder, start + 1, index - 1);
      root.right = bstFromPreorder(preorder, index, end);

      return root;
    }
  }
}
