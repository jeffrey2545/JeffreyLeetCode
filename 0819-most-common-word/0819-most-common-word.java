class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // banned全部放入set
        Set<String> set = new HashSet<>();
        for (String word : banned) {
            set.add(word);
        }
        // 全部換成小寫
        // 標點符號拿掉
        StringBuilder newParaSB = new StringBuilder();
        for (char ch : paragraph.toCharArray()) {
            if (Character.isLetter(ch)) {
                newParaSB.append(Character.toLowerCase(ch));
                continue;
            } else if (ch == ' ') {
                newParaSB.append(ch);
                continue;
            } else {
                newParaSB.append(' ');
                continue;
            }
        }
        String newPara = newParaSB.toString();
        // System.out.println("'"+ newPara + "'");
        // 按空格取出單詞並放入hashmap來記次數, 同時去set檢查是否被banned
        Map<String, Integer> map = new HashMap<>();
        String word = "";
        for (char ch : newPara.toCharArray()) {
            if (ch == ' ') {
                // System.out.println(word);
                if (word.equals("")) {
                    continue;
                }
                if (set.contains(word)) {
                    word = "";
                    continue;
                }
                if (map.containsKey(word)) {
                    int count = map.get(word);
                    map.replace(word, count, count + 1);
                } else {
                    map.put(word, 1);
                }
                word = "";
            } else {
                word = word + ch;
            }
        }
        
        if (!set.contains(word) && (!word.equals(""))) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.replace(word, count, count + 1);
            } else {
                map.put(word, 1);
            }
        }
        // 便利hashmap找出次數最多 answer
        // System.out.println(map);
        String result = "";
        int freq = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > freq) {
                result = entry.getKey();
                freq = entry.getValue();
            }
        }
        return result;
    }
}