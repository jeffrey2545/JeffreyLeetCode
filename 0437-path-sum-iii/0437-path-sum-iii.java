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
    int count;
    
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        dfs(root, targetSum, 0, prefix);
        return count;
    }
    
    public void dfs(TreeNode root, int targetSum, long currSum, Map<Long, Integer> prefix) {
        if (root == null) {
            return;
        }
        
        currSum = currSum + root.val;
        
        if (currSum == targetSum) {
            count++;
        }
        
        if (prefix.containsKey(currSum - targetSum)) {
            count = count + prefix.get(currSum - targetSum);
        }
        
        prefix.put(currSum , prefix.getOrDefault(currSum, 0) + 1);
        
        dfs(root.left, targetSum, currSum, prefix);
        dfs(root.right, targetSum, currSum, prefix);
        
        prefix.put(currSum , prefix.get(currSum) - 1);
    }
}