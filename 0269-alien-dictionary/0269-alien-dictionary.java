class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new ArrayList<>());
                indegree.put(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char char1 = word1.charAt(j);
                char char2 = word2.charAt(j);
                if (char1 != char2) {
                    List<Character> next = graph.get(char1);
                    next.add(char2);
                    graph.put(char1, next);
                    indegree.put(char2, indegree.get(char2) + 1);
                    break;
                }
            }
        }
        
        Queue<Character> queue = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        
        for (Character key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.add(key);
            }
        }
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            ans.append(curr);
            List<Character> next = graph.get(curr);
            for (char c : next) {
                int count = indegree.get(c);
                count--;
                indegree.put(c, count);
                if (count == 0) {
                    queue.add(c);
                }
            }
        }
        
        if (ans.length() < graph.size()) {
            return "";
        }
        return ans.toString();
    }
}