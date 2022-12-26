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
    public int closestValue(TreeNode root, double target) {
        // int result = Integer.MAX_VALUE;
        int result = dfs(root, target, Integer.MAX_VALUE);
        return result;
    }
    
    public int dfs(TreeNode root, double target, int result) {
        if (root == null) {
            return result;
        }
        if (Math.abs(result - target) > Math.abs(root.val - target)) {
            // System.out.println("in");
            // System.out.println(root.val);
            result = root.val;
            // System.out.println(result);
        }
        
        if (root.left == null && root.right == null) {
            return result;
        }
        
        if (target > root.val) {
            result = dfs(root.right, target, result);
        } else {
            result = dfs(root.left, target, result);
        }
        return result;
    }
}