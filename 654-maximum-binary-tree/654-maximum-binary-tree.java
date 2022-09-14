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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int maxPoint = findMax(nums);
        int maxNum = nums[maxPoint];
        TreeNode result = new TreeNode(maxNum);
        
        if (maxPoint > 0 && maxPoint < nums.length - 1) {
            int[] leftNums = Arrays.copyOfRange(nums, 0, maxPoint);
            int[] rightNums = Arrays.copyOfRange(nums, maxPoint + 1, nums.length);
            result.left = constructMaximumBinaryTree(leftNums);
            result.right = constructMaximumBinaryTree(rightNums);
        } else if (maxPoint == 0) {
            int[] rightNums = Arrays.copyOfRange(nums, maxPoint + 1, nums.length);
            result.right = constructMaximumBinaryTree(rightNums);
        } else if (maxPoint == nums.length - 1) {
            int[] leftNums = Arrays.copyOfRange(nums, 0, maxPoint);
            result.left = constructMaximumBinaryTree(leftNums);
        }
        return result;
    }
    
    public int findMax(int[] nums) {
        int max = nums[0];
        int point = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                point = i;
            }
        }
        return point;
    }
}