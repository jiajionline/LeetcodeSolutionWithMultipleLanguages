class MyCalendarThree {
    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int active = 0, ans = 0;
        // the map is sorted
        for (int d: map.values()) {
            active += d;
            if (active > ans) ans = active;
        }
        return ans;
    }
}