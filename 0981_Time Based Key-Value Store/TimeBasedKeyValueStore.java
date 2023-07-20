class TimeMap {
    private Map<String, List<Pair<Integer,String>>> cache;

    public TimeMap() {
        cache = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!cache.containsKey(key)) cache.put(key, new ArrayList<Pair<Integer,String>>());
        cache.get(key).add(new Pair<Integer,String>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!cache.containsKey(key)) return "";
        List<Pair<Integer,String>> list = cache.get(key);
        String ans = search(list, timestamp);
        return ans;
    }

    private String search(List<Pair<Integer,String>> list, int target) {
        int l = 0, r = list.size();
        while(l < r) {
            int mid = (r-l)/2 + l;
            Pair<Integer,String> midPair = list.get(mid);
            if(midPair.getKey() > target) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        l = l-1;
        if(l>=0) return list.get(l).getValue();
        return "";
    }
}