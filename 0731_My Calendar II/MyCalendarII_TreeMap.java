class MyCalendarTwo {
    
    private List<int[]> bookList;
    private TreeMap<Integer,Integer> intersectionMap;
 
    public MyCalendarTwo() {
        bookList = new ArrayList<>();
        intersectionMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if(!check(start, end)) return false;
        
        for (int[] range : bookList) {
            int ss = Math.max(range[0], start);
            int ee = Math.min(range[1], end);
            if (ss < ee) intersectionMap.put(ss,ee);
        }
        
        bookList.add(new int[]{start, end});
        return true;
    }
    
    private boolean check(int start, int end) {
        Integer lb = intersectionMap.floorKey(start);
        if(lb != null && intersectionMap.get(lb) > start) return false;
        Integer ub = intersectionMap.ceilingKey(start);
        if(ub != null && ub < end) return false;
        return true;
    }
 
}