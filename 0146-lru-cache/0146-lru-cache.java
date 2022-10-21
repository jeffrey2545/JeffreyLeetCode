class LRUCache {
    
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        
        if (map.size() > cap) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */