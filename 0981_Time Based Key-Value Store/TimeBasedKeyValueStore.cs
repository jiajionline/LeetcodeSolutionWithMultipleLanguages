public class TimeMap {
    private Dictionary<string, List<Tuple<int,string>>> dict;
    public TimeMap() {
        dict = new Dictionary<string, List<Tuple<int, string>>>();
    }
    
    public void Set(string key, string value, int timestamp) {
        if(!dict.ContainsKey(key))
        {
            var list = new List<Tuple<int, string>>();
            list.Add(Tuple.Create(timestamp, value));
            dict.Add(key, list);
        }
        else
        {
            dict[key].Add(Tuple.Create(timestamp, value));    
        }
            
    }
    
    public string Get(string key, int timestamp) {
        if(!dict.ContainsKey(key)) return "";
        var list = dict[key];
        var l = 0;
        var r = list.Count;
        
        while(l < r)
        {
            var mid = (r-l)/2 + l;
            if(list[mid].Item1 > timestamp)
                r = mid;
            else
                l = mid+1;
        }
        
        if (l-1 >= 0 && l-1 < list.Count) 
            return list[l-1].Item2;
        else
            return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.Set(key,value,timestamp);
 * string param_2 = obj.Get(key,timestamp);
 */