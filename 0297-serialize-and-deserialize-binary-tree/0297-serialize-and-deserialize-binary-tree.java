/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            ans.append(",");
            if (curr == null) {
                ans.append("null");
            } else {
                ans.append(String.valueOf(curr.val));
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        Queue<String> queue = new LinkedList<>();
        Queue<TreeNode> posQueue = new ArrayDeque<>();
        for (String string : dataArr) {
            queue.add(string);
        }
        queue.poll();
        String rootString = queue.poll();
        if (rootString.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(rootString));
        posQueue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = posQueue.poll();
            String leftString = queue.poll();
            String rightString = queue.poll();
            TreeNode left;
            TreeNode right;
            if (leftString.equals("null")) {
                curr.left = null;
            } else {
                left = new TreeNode(Integer.valueOf(leftString));
                posQueue.add(left);
                curr.left = left;
            }
            
            if (rightString.equals("null")) {
                curr.right = null;
            } else {
                right = new TreeNode(Integer.valueOf(rightString));
                posQueue.add(right);
                curr.right = right;
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));