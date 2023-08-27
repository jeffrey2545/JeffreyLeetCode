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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
    
    public void dfs(TreeNode root, int targetSum, List<Integer> currPath, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                currPath.add(root.val);
                ans.add(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);
            }
            return;
        }
        
        currPath.add(root.val);
        if (root.left != null) {
            dfs(root.left, targetSum - root.val, currPath, ans);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val, currPath, ans);
        }
        currPath.remove(currPath.size() - 1);
        
        return;
    }
}