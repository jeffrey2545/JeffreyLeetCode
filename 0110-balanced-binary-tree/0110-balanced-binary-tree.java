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
        if (root == null) {
            return new Pair(0, true);
        }
        
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        
        if (!left.balance || !right.balance) {
            return new Pair(0, false);
        }
        if (Math.abs(left.height - right.height) > 1) {
            return new Pair(0, false);
        }
        return new Pair(Math.max(left.height, right.height) + 1, true);
    }
}