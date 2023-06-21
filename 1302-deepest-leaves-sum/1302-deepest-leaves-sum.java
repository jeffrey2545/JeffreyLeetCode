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
    public int max;
    
    public int deepestLeavesSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map, 0);
        
        int ans = 0;
        for (int num : map.get(max)) {
            ans = ans + num;
        }
        return ans;
    }
    
    public void dfs(TreeNode root, HashMap<Integer, List<Integer>> map, int level) {
        if (root.left == null && root.right == null) {
            max = Math.max(max, level);
            if (map.containsKey(level)) {
                List<Integer> list = map.get(level);
                list.add(root.val);
                map.put(level, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                map.put(level, list);
            }
            return;
        }
        
        if (root.left != null) {
            dfs(root.left, map, level + 1);
        }
        if (root.right != null) {
            dfs(root.right, map, level + 1);
        }
        
        return;
    }
}