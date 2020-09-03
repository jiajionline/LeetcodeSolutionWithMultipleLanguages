class MyCalendarTwo {
    
    private List<int[]> bookList;
    private List<int[]> intersectionList;
 
    public MyCalendarTwo() {
        bookList = new ArrayList<>();
        intersectionList = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] range : intersectionList)
            if (Math.max(range[0], start) < Math.min(range[1], end))  return false;
        
        for (int[] range : bookList) {
            int ss = Math.max(range[0], start);
            int ee = Math.min(range[1], end);
            if (ss < ee) intersectionList.add(new int[]{ss, ee});
        }
        
        bookList.add(new int[]{start, end});
        return true;
    }
 
}