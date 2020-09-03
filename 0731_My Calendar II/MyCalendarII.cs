public class MyCalendarTwo {

    private List<Tuple<int,int>> bookList = new List<Tuple<int,int>>();
    private List<Tuple<int,int>> intersectionList = new List<Tuple<int,int>>();

    public MyCalendarTwo() {
        
    }
    
    public bool Book(int start, int end) {
        foreach (var v in intersectionList)
        {
            if(Math.Max(v.Item1, start) < Math.Min(v.Item2, end)) return false;
        }

        foreach (var v in bookList){
            if(Math.Max(v.Item1, start) < Math.Min(v.Item2, end)){
                intersectionList.Add(new Tuple<int,int>(Math.Max(v.Item1, start), Math.Min(v.Item2, end)));
            }
        }

        bookList.Add(new Tuple<int,int>(start, end));
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * bool param_1 = obj.Book(start,end);
 */