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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        if (root.left == null && root.right == null) {
            return root;
        }
        
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null) {
            left = invertTree(root.left);
        }
        if (root.right != null) {
            right = invertTree(root.right);
        }
        
        root.left = right;
        root.right = left;
        return root;
    }
}