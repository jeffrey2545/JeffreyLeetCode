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
public class Pair {
    TreeNode node;
    int ver;
    Pair(TreeNode node, int ver) {
        this.node = node;
        this.ver = ver;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(new ArrayList<>());
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        
        queue.add(new Pair(root, 0));
        List<Integer> initList = new ArrayList<>();
        initList.add(root.val);
        map.put(0, initList);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                if (pair.node.left != null) {
                    queue.add(new Pair(pair.node.left, pair.ver - 1));
                    if (!map.containsKey(pair.ver - 1)) {
                        List<Integer> newlist = new ArrayList<>();
                        map.put(pair.ver - 1, newlist);
                    }
                    List<Integer> list = map.get(pair.ver - 1);
                    list.add(pair.node.left.val);
                    map.put(pair.ver - 1, list);
                }
                if (pair.node.right != null) {
                    queue.add(new Pair(pair.node.right, pair.ver + 1));
                    if (!map.containsKey(pair.ver + 1)) {
                        List<Integer> newlist = new ArrayList<>();
                        map.put(pair.ver + 1, newlist);
                    }
                    List<Integer> list = map.get(pair.ver + 1);
                    list.add(pair.node.right.val);
                    map.put(pair.ver + 1, list);
                }
            }
        }
        
        int min = 0;
        while (map.containsKey(min)) {
            min--;
        }
        min++;
        
        List<List<Integer>> ans = new ArrayList<>();
        while (map.containsKey(min)) {
            ans.add(map.get(min));
            min++;
        }
        
        return ans;
    }
}