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
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(paths, root, path);
        
        List<String> ans = new ArrayList<>();
        for (List<Integer> list : paths) {
            if (list.size() == 1) {
                ans.add(list.get(0).toString());
            } else if (list.size() == 2) {
                String a = list.get(0).toString() + "->" + list.get(1).toString();
                ans.add(a);
            } else {
                String first = list.get(0).toString();
                String last = list.get(list.size() - 1).toString();
                String middle = "";
                for (int i = 1; i < list.size() - 1; i++) {
                    middle = middle + "->" + list.get(i).toString();
                }
                String a = first + middle + "->" + last;
                ans.add(a);
            }
        }
        return ans;
    }
    
    public void dfs(List<List<Integer>> paths, TreeNode root, List<Integer> path) {
        if (root.left == null && root.right == null) {
            // path.add(root.val);
            paths.add(new ArrayList<>(path));
            return;
        }
        
        if (root.left != null) {
            path.add(root.left.val);
            dfs(paths, root.left, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            dfs(paths, root.right, path);
            path.remove(path.size() - 1);
        }
        
        return;
    }
}