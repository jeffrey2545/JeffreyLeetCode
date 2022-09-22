/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            // System.out.println("第一個");
            // System.out.println(root.val);
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left == null && right != null) {
            // System.out.println("第二個");
            // System.out.println(right.val);
            return right;
        }
        if (right == null && left != null) {
            // System.out.println("第三個");
            // System.out.println(left.val);
            return left;
        }
        if (left == null && right == null) {
            return null;
        }
        // System.out.println("第四個");
        // System.out.println(root.val);
        return root;
    }
}