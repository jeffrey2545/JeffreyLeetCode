/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     int lcs;
 *     int curr;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Pair {
    int lcs;
    int curr;
    Pair(int lcs, int curr) {
        this.lcs = lcs;
        this.curr = curr;
    }
}
class Solution {
    public int longestConsecutive(TreeNode root) {
        Pair pair = dfs(root);
        return pair.lcs;
    }
    
    public Pair dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            Pair pair = new Pair(1, 1);
            return pair;
        }
        
        Pair rootPair = new Pair(0, 0);
        if (root.left != null) {
            Pair leftPair = dfs(root.left);
            if (root.val + 1 == root.left.val) {
                int lcs = Math.max(leftPair.lcs, leftPair.curr + 1);
                rootPair.lcs = lcs;
                
                rootPair.curr = leftPair.curr + 1;
                // System.out.println(rootPair.lcs);
            } else {
                rootPair.lcs = leftPair.lcs;
                rootPair.curr = 1;
            }
        }
        if (root.right != null) {
            Pair rightPair = dfs(root.right);
            if (root.val + 1 == root.right.val) {
                int lcs = Math.max(rightPair.lcs, rightPair.curr + 1);
                rootPair.lcs = Math.max(lcs, rootPair.lcs);
                
                rootPair.curr = Math.max(rightPair.curr + 1, rootPair.curr);
                // System.out.println(rootPair.lcs);Math.max()
            } else {
                rootPair.lcs = Math.max(rightPair.lcs, rootPair.lcs);
                rootPair.curr = Math.max(rootPair.curr, 1);
                // System.out.println(rootPair.lcs);
            }
        }
        // System.out.println("root.val"+root.val);
        // System.out.println(rootPair.lcs);
        // System.out.println(rootPair.curr);
        return rootPair;
    }
}