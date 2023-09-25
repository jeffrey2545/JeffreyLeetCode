class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long time = 1;
        for (int task : tasks) {
            if (map.containsKey(task) && map.get(task) + space >= time) {
                time = map.get(task) + space + 1;
            }
            map.put(task, time);
            time++;
        }
        time--;
        return time;
    }
}