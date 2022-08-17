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
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // use bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        
        while (!queue.isEmpty()) {
            TreeNode pollQueue = queue.poll();
            result = result + Math.abs(sumTree(pollQueue.left) - sumTree(pollQueue.right));
            
            if (pollQueue.left != null) {
                queue.offer(pollQueue.left);
            }
            if (pollQueue.right != null) {
                queue.offer(pollQueue.right);
            }
        }
        
        return result;
    }
    public int sumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        } else if (root.left == null) {
            return root.val + sumTree(root.right);
        } else if (root.right == null) {
            return root.val + sumTree(root.left);
        } else {
            return root.val + sumTree(root.left) + sumTree(root.right);
        }
    }
}