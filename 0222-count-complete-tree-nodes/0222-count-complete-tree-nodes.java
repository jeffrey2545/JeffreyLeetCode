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
    public int countNodes(TreeNode root) {
        if (root == null) {
          return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
          result++;
          TreeNode tmpNode = queue.poll();
          if (tmpNode.left != null) {
            queue.offer(tmpNode.left);
          }
          if (tmpNode.right != null) {
            queue.offer(tmpNode.right);
          }
        }
        return result;
    }
}