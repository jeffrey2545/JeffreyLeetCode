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
    int ans;
    
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        int[] arr = dfs(root);
        return ans;
    }
    
    public int[] dfs(TreeNode root) {// sum, count
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] merge = new int[]{left[0] + right[0] + root.val, left[1] + right[1] + 1};
        
        if (merge[0] / merge[1] == root.val) {
            ans++;
        }
        return merge;
    }
}