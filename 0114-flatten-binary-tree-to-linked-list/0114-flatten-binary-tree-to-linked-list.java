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
    public void flatten(TreeNode root) {
        if (root == null) {return;}
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        // root = list.get(0);
        root.left = null;
        TreeNode index = root;
        for (int i = 1; i < list.size(); i++) {
            index.right = list.get(i);
            index = index.right;
        }
        return;
    }
    public void dfs(TreeNode root, List<TreeNode> list) {
        TreeNode node = new TreeNode(root.val);
        list.add(node);
        if (root.left != null) {
            dfs(root.left, list);
        }
        if (root.right != null) {
            dfs(root.right, list);
        }
        return;
    }
}