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
    Stack<Integer> stack = new Stack<>();
    List<String> list = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return list;
    }
    
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        stack.push(root.val);
        dfs(root.left);
        dfs(root.right);
        if (root.left == null && root.right == null) {
            iteration();
        }
        stack.pop();
    }
    
    public void iteration() {
        String path = "";
        Stack<Integer> tmpStack = (Stack<Integer>)stack.clone();
        while (!tmpStack.isEmpty()) {
            String val = String.valueOf(tmpStack.pop());
            if (tmpStack.isEmpty()) {
                path = val + path;
            } else {
                path = "->" + val + path;
            }
        }
        
        list.add(path);
    }
}