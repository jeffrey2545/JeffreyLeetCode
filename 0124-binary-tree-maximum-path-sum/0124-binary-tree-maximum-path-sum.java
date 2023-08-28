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
    int ans = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int a = dfs(root);
        return ans;
    }
    
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftPath = dfs(root.left);
        int rightPath = dfs(root.right);
        leftPath = Math.max(leftPath, 0);
        rightPath = Math.max(rightPath, 0);
        
        ans = Math.max(ans, root.val + leftPath + rightPath);
        
        return root.val + Math.max(leftPath, rightPath);
    }
}