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
    Map<Integer, Integer> map = new HashMap<>();
    int mode = 1;
    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> result = new ArrayList<Integer>();
        map.containsValue(mode);
        map.forEach((key, value) -> {
            if (value == mode) {
                result.add(key);
            }
        });
        System.out.print(result);
        // Integer[] resultArray = new Integer[result.size()];
        // resultArray = result.toArray(resultArray);
        // int[] strings = result.toArray(int[]::new);
        int[] example2 = result.stream().mapToInt(Integer::intValue).toArray();
        int[] aa = {1,2};
        return example2;
    }
    
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // insert hash
        if (map.containsKey(root.val)) {
            int count = map.get(root.val);
            mode = Math.max(mode, count + 1);
            map.replace(root.val, count, count + 1);
        } else {
            map.put(root.val, 1);
        }
        dfs(root.left);
        dfs(root.right);
    }
}