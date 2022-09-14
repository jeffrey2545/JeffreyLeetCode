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
    public boolean isBalanced(TreeNode root) {
        Result result = balance(root);
        return result.isBalance;
    }
    
    public Result balance(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }
        
        Result leftTree = balance(root.left);
        Result rightTree = balance(root.right);
        
        if (!leftTree.isBalance || !rightTree.isBalance) {
            return new Result(false, 0);
        }
        if (Math.abs(leftTree.height - rightTree.height) > 1) {
            return new Result(false, 0);
        }
        return new Result(true, Math.max(leftTree.height, rightTree.height) + 1);
    }
    
    public class Result {
        boolean isBalance;
        int height;
        Result(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }
}