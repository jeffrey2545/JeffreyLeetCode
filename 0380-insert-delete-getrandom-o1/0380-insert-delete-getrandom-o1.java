class RandomizedSet {
    
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            int index = list.size() - 1;
            map.put(val, index);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            map.remove(val, index);
            
            int lastIndex = list.size() - 1;
            int last = list.get(lastIndex);
            
            list.set(index, last);
            list.remove(lastIndex);
            
            map.replace(last, lastIndex, index);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */