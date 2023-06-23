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
    public int goodCount;
    
    public int goodNodes(TreeNode root) {
        goodCount = 0;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, path);
        return goodCount;
    }
    
    public void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        
        if (root.val == Collections.max(path)) {
            goodCount++;
        }
        
        if (root.left != null) {
            path.add(root.left.val);
            dfs(root.left, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            dfs(root.right, path);
            path.remove(path.size() - 1);
        }
        
        return;
    }
}