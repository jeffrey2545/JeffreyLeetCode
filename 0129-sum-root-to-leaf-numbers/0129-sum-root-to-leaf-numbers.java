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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer>numList = new ArrayList<>();
        dfs(root, numList, 0);
        int ans = 0;
        for (int num : numList) {
            ans = ans + num;
        }
        return ans;
    }
    
    private void dfs(TreeNode root, List<Integer>numList, int num) {
        if (root.left == null && root.right == null) {
            num = (num * 10) + root.val;
            numList.add(num);
            return;
        }
        
        if (root.left != null) {
            dfs(root.left, numList, (num * 10) + root.val);
        }
        if (root.right != null) {
            dfs(root.right, numList, (num * 10) + root.val);
        }
        return;
    }
}