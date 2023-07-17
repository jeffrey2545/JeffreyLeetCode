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
    Map<Integer, Integer> map;
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int val = preorder[preorderIndex++];
        TreeNode head = new TreeNode(val);
        int headIndex = map.get(val);
        
        head.left = dfs(preorder, left, headIndex - 1);
        head.right = dfs(preorder, headIndex + 1, right);
        
        return head;
    }
}