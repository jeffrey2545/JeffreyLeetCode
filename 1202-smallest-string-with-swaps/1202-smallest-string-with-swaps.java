class UF {
    int[] parent;
    int[] rank;
    
    public UF(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }
    
    public boolean union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        
        if (aParent == bParent) {
            return false;
        }
        
        if (rank[aParent] > rank[bParent]) {
            parent[bParent] = aParent;
        } else if (rank[aParent] < rank[bParent]) {
            parent[aParent] = bParent;
        } else {
            parent[aParent] = bParent;
            rank[bParent]++;
        }
        
        return true;
    }
}

class Solution {
    Map<Integer, Character> map = new HashMap<>();
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // use pairs to union
        UF uf = new UF(s.length());
        for (List<Integer> list : pairs) {
            uf.union(list.get(0), list.get(1));
        }
        // build map for uf
        Map<Integer, List<Integer>> ufMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int parent = uf.find(i);
            List<Integer> children;
            if (ufMap.containsKey(parent)) {
                children = ufMap.get(parent);
            } else {
                children = new ArrayList<>();
            }
            children.add(i);
            ufMap.put(parent, children);
        }
        // find pair
        for (List<Integer> list : ufMap.values()) {
            int[] pair = list.stream().mapToInt(Integer::intValue).toArray();
            help(pair, s);
        }
        // build ans
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append(map.get(i));
        }
        return ans.toString();
    }
    public void help(int[] pair, String s) {
        char[] cArr = new char[pair.length];
        for (int i = 0; i < pair.length; i++) {
            cArr[i] = s.charAt(pair[i]);
        }
        
        Arrays.sort(pair);
        Arrays.sort(cArr);
        
        for (int i = 0; i < pair.length; i++) {
            map.put(pair[i], cArr[i]);
        }
        return;
    }
}
// [d,b]
// [0,3]

// [c,a]
// [1,2]