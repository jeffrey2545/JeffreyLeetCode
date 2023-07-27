class TimeMap {
    HashMap<String, TreeMap> map1 = new HashMap<>();

    public TimeMap() {
        map1 = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map1.containsKey(key)) {
            TreeMap<Integer, String> map2 = map1.get(key);
            map2.put(timestamp, value);
            map1.put(key, map2);
        } else {
            TreeMap<Integer, String> map2 = new TreeMap<>();
            map2.put(timestamp, value);
            map1.put(key, map2);
        }
        return;
    }
    
    public String get(String key, int timestamp) {
        if (!map1.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> map2 = map1.get(key);
        Integer floor = map2.floorKey(timestamp);
        if (floor != null) {
            return map2.get(floor);
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */