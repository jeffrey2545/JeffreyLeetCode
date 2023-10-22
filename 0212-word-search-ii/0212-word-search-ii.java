class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
        public TrieNode() {}
    }
    
    List<String> ans;
    int rowLength;
    int colLength;
    char[][] _board;
    
    public List<String> findWords(char[][] board, String[] words) {
        // init construct
        ans = new ArrayList<>();
        rowLength = board.length;
        colLength = board[0].length;
        _board = board;
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char letter : word.toCharArray()) {
                if (!curr.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    curr.children.put(letter, newNode);
                }
                curr = curr.children.get(letter);
            }
            curr.word = word;
        }
        
        // dfs
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (root.children.containsKey(board[row][col])) {
                    dfs(row, col, root);
                }
            }
        }
        
        return ans;
    }
    
    public void dfs(int row, int col, TrieNode parent) {
        char letter = _board[row][col];
        TrieNode curr = parent.children.get(letter);
        
        if (curr.word != null) {
            ans.add(curr.word);
            curr.word = null;
        }
        
        _board[row][col] = '#';
        
        int[] deltaX = new int[]{1, -1, 0, 0};
        int[] deltaY = new int[]{0, 0, 1, -1};
        for (int dir = 0; dir < 4; dir++) {
            int newRow = row + deltaX[dir];
            int newCol = col + deltaY[dir];
            if (newRow < 0 || newRow >= rowLength || newCol < 0 || newCol >= colLength) {
                continue;
            }
            if (curr.children.containsKey(_board[newRow][newCol])) {
                dfs(newRow, newCol, curr);
            }
        }
        
        _board[row][col] = letter;
    }
}