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
    public int rob(TreeNode root) {
        Pair<Integer, Integer> ans = dfs(root);
        return Math.max(ans.getKey(), ans.getValue());
    }
    
    public Pair<Integer, Integer> dfs(TreeNode root) {// 取, 不取
        if (root == null) {
            return new Pair<>(0, 0);
        }
        
        Pair<Integer, Integer> left = dfs(root.left);
        Pair<Integer, Integer> right = dfs(root.right);
        
        int take = root.val + left.getValue() + right.getValue();
        int noTake = Math.max(left.getKey(), left.getValue()) + Math.max(right.getKey(), right.getValue());
        return new Pair<>(take, noTake);
    }
}