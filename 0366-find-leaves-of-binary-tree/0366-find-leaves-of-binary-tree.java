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
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        int level = dfs(root);
        return ans;
    }
    
    public int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            // bottom
            List<Integer> list;
            if (ans.size() >= 1) {
                list = ans.get(0);
                list.add(root.val);
                ans.set(0, list);
            } else {
                list = new ArrayList<>();
                list.add(root.val);
                ans.add(list);
            }
            return 1;
        }
        
        int level;
        if (root.left == null) {
            // has right
            level = dfs(root.right);
        } else if (root.right == null) {
            // has left
            level = dfs(root.left);
        } else {
            // has both left and right
            level = Math.max(dfs(root.right), dfs(root.left));
        }
        List<Integer> list;
        if (ans.size() >= 1 + level) {
            list = ans.get(level);
            list.add(root.val);
            ans.set(level, list);
        } else {
            list = new ArrayList<>();
            list.add(root.val);
            ans.add(list);
        }
        return level + 1;
    }
}