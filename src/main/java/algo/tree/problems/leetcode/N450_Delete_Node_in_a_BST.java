package algo.tree.problems.leetcode;

import algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * 1. Search for a node to remove.
 * 2. If the node is found, delete the node.
 */
public class N450_Delete_Node_in_a_BST {

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

    TreeNode rootNode;

    public TreeNode deleteNode(TreeNode root, int key) {
      this.rootNode = root;

      TreeNode currentNode = this.rootNode;
      TreeNode parentNode = null;

      while(currentNode != null) {
        if (key < currentNode.val) {
          parentNode = currentNode;
          currentNode = currentNode.left;
        } else if (currentNode.val < key) {
          parentNode = currentNode;
          currentNode = currentNode.right;
        } else {
          break;
        }
      }

      if (currentNode == null) {
        return this.rootNode;
      }

      if (currentNode.left == null) {
        shift(parentNode, currentNode, currentNode.right);
      } else if (currentNode.right == null) {
        shift(parentNode, currentNode, currentNode.left);
      } else {
        TreeNode successorNode = currentNode.right;
        TreeNode successorParentNode = currentNode;

        while(successorNode.left != null) {
          successorParentNode = successorNode;
          successorNode = successorNode.left;
        }

        if (currentNode != successorParentNode) {
          shift(successorParentNode, successorNode, successorNode.right);
          successorNode.right = currentNode.right;
        }

        successorNode.left = currentNode.left;
        shift(parentNode, currentNode, successorNode);
      }

      return this.rootNode;
    }

    private void shift(TreeNode parentNode, TreeNode toDeletedNode, TreeNode nextNode) {
      if (parentNode == null) {
        this.rootNode = nextNode;
      } else if (toDeletedNode.val < parentNode.val){
        parentNode.left = nextNode;
      } else {
        parentNode.right = nextNode;
      }
    }
  }

}
