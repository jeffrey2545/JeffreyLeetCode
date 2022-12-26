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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        int closet = dfs(root, target, Integer.MAX_VALUE, list);
        
        // System.out.println(list);
        // System.out.println(closet);
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == closet) {
                index = i;
                break;
            }
        }
        // System.out.println("index:"+ index);
        
        int rightIndex = index + 1;
        // System.out.println("rightIndex:"+ rightIndex);
        int leftIndex = index - 1;
        // System.out.println("leftIndex:"+ leftIndex);
        List<Integer> result = new ArrayList<>();
        result.add(closet);
        k--;
        while (k > 0) {
            if (rightIndex >= list.size()) {
                result.add(list.get(leftIndex));
                leftIndex--;
                k--;
                continue;
            }
            if (leftIndex < 0) {
                result.add(list.get(rightIndex));
                rightIndex++;
                k--;
                continue;
            }
            
            double right = Math.abs(target - list.get(rightIndex));
            double left = Math.abs(target - list.get(leftIndex));
            if (right > left) {
                result.add(list.get(leftIndex));
                leftIndex--;
                k--;
            } else if (right < left) {
                result.add(list.get(rightIndex));
                rightIndex++;
                k--;
            } else {
                if (k >= 2) {
                    result.add(list.get(leftIndex));
                    leftIndex--;
                    k--;
                    result.add(list.get(rightIndex));
                    rightIndex++;
                    k--;
                } else {
                    result.add(list.get(leftIndex));
                    leftIndex--;
                    k--;
                }
            }
        }
        return result;
    }
    
    public int dfs(TreeNode root, double target, int closet, List<Integer> list) {
        if (root == null) {
            return closet;
        }
        if (Math.abs(closet - target) > Math.abs(root.val - target)) {
            closet = root.val;
        }
        
        closet = dfs(root.left, target, closet, list);
        list.add(root.val);
        closet = dfs(root.right, target, closet, list);

        return closet;
    }
}