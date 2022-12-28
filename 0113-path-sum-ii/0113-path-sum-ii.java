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
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum - root.val, path, result);
        return result;
    }
    
    public void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                path.add(root.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            } else {
                return;
            }
        }
        
        if (root.left != null) {
            path.add(root.val);
            dfs(root.left, targetSum - root.left.val, path, result);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.val);
            dfs(root.right, targetSum - root.right.val, path, result);
            path.remove(path.size() - 1);
        }
        
        return;
    }
}