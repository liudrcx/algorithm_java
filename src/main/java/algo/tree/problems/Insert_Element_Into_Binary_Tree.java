package algo.tree.problems;

import algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Insert_Element_Into_Binary_Tree {

  public static class Solution1 {

    public void insert(TreeNode root, int newVal) {
      TreeNode newNode = new TreeNode(newVal);

      if (root == null) {
        root = newNode;
        return;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while(!queue.isEmpty()) {
        TreeNode node = queue.poll();

        if (node.left != null) {
          queue.offer(node.left);
        } else {
          node.left = newNode;
          return;
        }

        if (node.right != null) {
          queue.offer(node.right);
        } else {
          node.right = newNode;
          return;
        }
      }
    }
  }
}
