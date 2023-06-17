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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
    
    public void dfs(TreeNode head, List<Integer> ans) {
        if (head == null) {
            return;
        }
        
        if (head.left == null && head.right != null) {
            ans.add(head.right.val);
        }
        if (head.left != null && head.right == null) {
            ans.add(head.left.val);
        }
        
        if (head.left != null) {
            dfs(head.left, ans);
        }
        if (head.right != null) {
            dfs(head.right, ans);
        }
        
        return;
    }
}