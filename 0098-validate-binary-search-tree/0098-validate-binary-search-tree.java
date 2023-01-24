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
class Node {
    boolean isBST;
    int maxNode;
    int minNode;
    Node() {
        
    }
    Node(boolean isBST, int maxNode, int minNode) {
        this.isBST = isBST;
        this.maxNode = maxNode;
        this.minNode = minNode;
    }
}
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root).isBST;
    }
    
    public Node dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            Node child = new Node(true, root.val, root.val);
            return child;
        }
        
        Node left = new Node();
        if (root.left != null) {
            left = dfs(root.left);
        }
        Node right = new Node();
        if (root.right != null) {
            right = dfs(root.right);
        }
        
        Node result = new Node(false, 0, 0);
        if (left.isBST && right.isBST) {
            if (root.val > left.maxNode && root.val < right.minNode) {
                result.isBST = true;
                result.maxNode = right.maxNode;
                result.minNode = left.minNode;
                return result;
            } else {
                return result;
            }
        } else if (left.isBST && root.right == null) {
            if (root.val > left.maxNode) {
                result.isBST = true;
                result.maxNode = root.val;
                result.minNode = left.minNode;
                return result;
            } else {
                return result;
            }
        } else if (right.isBST && root.left == null) {
            if (root.val < right.minNode) {
                result.isBST = true;
                result.maxNode = right.maxNode;
                result.minNode = root.val;
                return result;
            } else {
                return result;
            }
        }
        else {
            return result;
        }
    }
}