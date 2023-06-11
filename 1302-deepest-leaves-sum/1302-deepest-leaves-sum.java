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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        queue.add(root);
        list.add(root.val);
        
        while (!queue.isEmpty()) {
            sum = 0;
            for (int val : list) {
                sum = sum + val;
            }
            
            list.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head.left != null) {
                    queue.add(head.left);
                    list.add(head.left.val);
                }
                if (head.right != null) {
                    queue.add(head.right);
                    list.add(head.right.val);
                }
            }
        }

        return sum;
    }
}