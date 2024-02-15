class Solution {
    boolean ans;
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // find root
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(leftChild[i])) {
                set.remove(leftChild[i]);
            }
            if (set.contains(rightChild[i])) {
                set.remove(rightChild[i]);
            }
        }
        if (set.size() != 1) {
            return false;
        }
        int root = 0;
        for (Integer val : set) {
            root = val;
        }
        // set to check duplicate
        // dfs
        ans = true;
        dfs(root, set, leftChild, rightChild);
        if (set.size() != n) {
            ans = false;
        }
        return ans;
    }
    public void dfs(int root, Set<Integer> set, int[] leftChild, int[] rightChild) {
        if (leftChild[root] == -1 && rightChild[root] == -1) {
            return;
        }
        
        if (leftChild[root] != -1) {
            int left = leftChild[root];
            if (set.contains(left)) {
                ans = false;
                return;
            }
            set.add(left);
            dfs(left, set, leftChild, rightChild);
        }
        if (rightChild[root] != -1) {
            int right = rightChild[root];
            if (set.contains(right)) {
                ans = false;
                return;
            }
            set.add(right);
            dfs(right, set, leftChild, rightChild);
        }
        // set.remove(left);
        // set.remove(right);
        return;
    }
}