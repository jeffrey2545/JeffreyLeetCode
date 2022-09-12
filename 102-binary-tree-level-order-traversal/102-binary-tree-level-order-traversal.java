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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        
        Queue<TreeNode> mainQueue = new LinkedList<>();
        mainQueue.offer(root);
        while (!mainQueue.isEmpty()) {
            int tmpSize = mainQueue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < tmpSize; i++) {
                TreeNode tmpNode = mainQueue.poll();
                tmpList.add(tmpNode.val);
                
                if (tmpNode.left != null) {
                    mainQueue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    mainQueue.offer(tmpNode.right);
                }
            }
            resultList.add(tmpList);
        }
        
        return resultList;
    }
}