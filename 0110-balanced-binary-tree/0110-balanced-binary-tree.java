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
public class Pair {
    int height;
    boolean balance;
    Pair(int height, boolean balance) {
        this.height = height;
        this.balance = balance;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return dfs(root).balance;
    }
    
    public Pair dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Pair(1, true);
        }
        
        Pair left = new Pair(0, true);
        Pair right = new Pair(0, true);
        if (root.left != null) {
            left = dfs(root.left);
        }
        if (root.right != null) {
            right = dfs(root.right);
        }
        
        if (left.balance && right.balance) {
            if (Math.abs(left.height - right.height) <= 1) {
                return new Pair(Math.max(left.height, right.height) + 1, true);
            }
        }
        return new Pair(0, false);
    }
}