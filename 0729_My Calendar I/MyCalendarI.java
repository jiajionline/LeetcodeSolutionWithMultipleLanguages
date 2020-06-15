import java.util.TreeMap;

class MyCalendar {
    private TreeMap<Integer, Integer> _booked;
    public MyCalendar() {
        _booked = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer lb = _booked.floorKey(start);
        if(lb != null && _booked.get(lb) > start) return false;
        Integer ub = _booked.ceilingKey(start);
        if(ub != null && ub < end) return false;
        _booked.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */