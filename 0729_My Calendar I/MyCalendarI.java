class MyCalendar {
    private TreeMap<Integer, Integer> _booked;
    public MyCalendar() {
        _booked = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        //The floorKey() method is used to return the greatest key less than or equal to given key from the parameter.
        Integer lb = _booked.floorKey(start);
        //get end mapped by lb
        if(lb != null && _booked.get(lb) > start) return false;
        //ceilingKey() returns the least key greater than or equal to the given key or null if the such a key is absent.
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