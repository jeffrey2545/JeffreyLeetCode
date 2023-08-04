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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.right == null) {
              return root.left;
            }
            TreeNode temper = root.left;
            root = root.right;
            modified(root, temper);
            return root;
        }
        if (root == null) {
            return root;
        }

        if (root.val > key) {
            // delete left
            TreeNode left = deleteNode(root.left, key);// new right
            root.left = left;
        } else {
            // delete right
            TreeNode right = deleteNode(root.right, key);// new left
            root.right = right;
        }
        
        return root;
    }

    public void modified(TreeNode root, TreeNode temper) {
        if (root.left == null) {
            root.left = temper;
            return;
        }
        modified(root.left, temper);
        return;
    }
}