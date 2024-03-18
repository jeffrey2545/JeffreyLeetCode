class Solution {
    Map<Integer, Set> map = new HashMap<>();// index, substring set
    
    public String[] shortestSubstrings(String[] arr) {
        buildMap(arr);
        
        String[] ans = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            String tempAns = "";
            for (int size = 1; size <= s.length(); size++) {
                for (int index = 0; index + size <= s.length(); index++) {
                    String subS = s.substring(index, index + size);
                    if (check(subS, i)) {
                        if (tempAns.length() == 0) {
                            tempAns = subS;
                        } else if (tempAns.length() > subS.length()) {
                            tempAns = subS;
                        } else if (tempAns.length() == subS.length()) {
                            if (tempAns.compareTo(subS) > 0) {
                                tempAns = subS;
                            }
                        }
                    }
                }
            }
            ans[i] = tempAns;
        }
        return ans;
    }
    
    public void buildMap(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            Set<String> set = new HashSet<>();
            // split
            for (int size = 1; size <= s.length(); size++) {
                for (int index = 0; index + size <= s.length(); index++) {
                    String subS = s.substring(index, index + size);
                    set.add(subS);
                }
            }
            map.put(i, set);
        }
        return;
    }
    
    public boolean check(String subS, int index) {
        for (Integer i : map.keySet()) {
            if (i == index) {
                continue;
            }
            if (map.get(i).contains(subS)) {
                return false;
            }
        }
        return true;
    }
}