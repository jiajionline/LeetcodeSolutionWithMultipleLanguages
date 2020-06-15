public class MyCalendar {

    private List<Tuple<int,int>> list = new List<Tuple<int,int>>();
    public MyCalendar() {
        
    }
    
    public bool Book(int start, int end) {
        foreach(var t in list){
            if(Math.Max(start, t.Item1) < Math.Min(end, t.Item2)) return false;
        }

        list.Add(new Tuple<int,int>(start,end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * bool param_1 = obj.Book(start,end);
 */