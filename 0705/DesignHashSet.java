class MyHashSet {
    private int len = 100000;
    private List<Integer>[] lists = new List[len];

    public MyHashSet() {
        
    }
    
    public void add(int key) {
        if(key < 0) key = Math.abs(key);
        int mod = key % len;
        if(lists[mod] == null) {
            lists[mod] = new LinkedList<Integer>();
            lists[mod].add(key);
        }else {
            List<Integer> list = lists[mod];
            for(int v : list) {
                if(v == key) return;
            }
            list.add(key);
        }
    }
    
    public void remove(int key) {
        if(key < 0) key = Math.abs(key);
        int mod = key % len;
        if(lists[mod] == null) return;
        
        List<Integer> list = lists[mod];
        list.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        if(key < 0) key = Math.abs(key);
        int mod = key % len;
        if(lists[mod] == null) return false;
        List<Integer> list = lists[mod];
        for(int v : list) {
            if(v == key) return true;
        }
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */