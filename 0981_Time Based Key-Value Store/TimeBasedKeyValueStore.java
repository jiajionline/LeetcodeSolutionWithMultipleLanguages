class Data {
    String val;
    int time;
    Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}
public class TimeMap {

    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<Data>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }
    
    protected String binarySearch(List<Data> list, int time) {
        int low = 0, high = list.size() ;
        while (low < high) {
            int mid = (high - low)/2 + low;
            if (list.get(mid).time <= time) {
                low = mid + 1;
            }
            else high = mid;
        }
        
        return (high == 0) ? "" : list.get(high-1).val;
    }
}
