class MyHashSet {
    private int len = 100000;
    private List<Integer>[] lists = new List[len];
    
    public void add(int key) {
        if(key < 0) key = Math.abs(key);
        int mod = key % len;
        if(lists[mod] == null) {
            lists[mod] = new LinkedList<Integer>();
            lists[mod].add(key);
        }else {
            List<Integer> list = lists[mod];
           if(list.contains(key)) return;
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
        return list.contains(key);
    }
}