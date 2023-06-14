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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int[] description : descriptions) {
            if (!map.containsKey(description[0])) {
                TreeNode node = new TreeNode(description[0]);
                map.put(description[0], node);
            }
            if (!map.containsKey(description[1])) {
                TreeNode node = new TreeNode(description[1]);
                map.put(description[1], node);
            }
            TreeNode parent = map.get(description[0]);
            TreeNode child = map.get(description[1]);
            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            set.add(description[0]);
            set.add(description[1]);
        }
        
        // find the root
        for (int[] description : descriptions) {
            set.remove(description[1]);
        }
        TreeNode root = new TreeNode();
        for (int val : set) {
            root = map.get(val);
        }
        return root;
    }
}