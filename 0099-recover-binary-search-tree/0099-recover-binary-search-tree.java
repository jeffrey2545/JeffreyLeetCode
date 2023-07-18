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
    public void recoverTree(TreeNode root) {
      List<TreeNode> inorder = new ArrayList<>();
      dfs(root, inorder);

      TreeNode pre = inorder.get(0);
      TreeNode wrong1 = null;
      TreeNode wrong2 = null;
      boolean change = false;
      for (int i = 1; i < inorder.size(); i++) {
        TreeNode curr = inorder.get(i);
        if (curr.val < pre.val) {
          if (!change) {
            wrong1 = pre;
            wrong2 = curr;
            change = true;
          } else {
            wrong2 = curr;
            break;
          }
        }
        pre = curr;
      }
      int temp = wrong1.val;
      wrong1.val = wrong2.val;
      wrong2.val = temp;
      return;
    }

    private void dfs(TreeNode root, List<TreeNode> inorder) {
      if (root == null) {
        return;
      }

      dfs(root.left, inorder);
      inorder.add(root);
      dfs(root.right, inorder);

      return;
    }
}