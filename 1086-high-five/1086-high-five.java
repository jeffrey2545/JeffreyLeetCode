class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        List<Integer> students = new ArrayList<>();
        
        for (int row = 0; row < items.length; row++) {
            int student = items[row][0];
            int score = items[row][1];
            
            if (map.containsKey(student)) {
                PriorityQueue<Integer> scores = map.get(student);
                scores.add(score);
                map.replace(student, map.get(student), scores);
            } else {
                PriorityQueue<Integer> scores = new PriorityQueue<>(Collections.reverseOrder());
                scores.add(score);
                map.put(student, scores);
                students.add(student);
            }
        }
        
        students.sort(null);
        int[][] ans = new int[students.size()][2];
        for (int x = 0; x < students.size(); x++) {
            int student = students.get(x);
            int sum = 0;
            PriorityQueue<Integer> scores = map.get(student);
            for (int i = 0; i < 5; i++) {
                sum = sum + scores.poll();
            }
            int ave = sum / 5;
            ans[x][0] = student;
            ans[x][1] = ave;
        }
        
        return ans;
    }
}