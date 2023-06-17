class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<String> initList = new ArrayList<>();
        if (strs.length == 0) {
            ans.add(initList);
            return ans;
        }
        initList.add(strs[0]);
        ans.add(initList);
        if (strs.length == 1) {
            return ans;
        }
        
        
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            boolean popIn = false;
            for (List<String> list : ans) {
                if (isAnagrams(list.get(0), str)) {
                    list.add(str);
                    popIn = true;
                    break;
                }
            }
            if (!popIn) {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                ans.add(newList);
            }
        }
        
        return ans;
    }
    
    public boolean isAnagrams(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] sArr = new int[123];
        Arrays.fill(sArr, 0);
        int[] tArr = new int[123];
        Arrays.fill(tArr, 0);
        
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i)]++;
            tArr[t.charAt(i)]++;
        }
        
        for (int i = 97; i < 123; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        
        return true;
    }
}