public class TimeMap {

    private Dictionary<string, List<Tuple<string,int>>> dict = new Dictionary<string, List<Tuple<string,int>>>();
    /** Initialize your data structure here. */
    public TimeMap() {
        
    }
    
    public void Set(string key, string value, int timestamp) {
        if(!dict.ContainsKey(key)) dict.Add(key, new List<Tuple<string,int>>());
        dict[key].Add(Tuple.Create(value, timestamp));
    }
    
    public string Get(string key, int timestamp) {
        if(dict.ContainsKey(key))
        {
            var list = dict[key];
            var l = 0;
            var r = list.Count-1;
            
            while(l <= r)
            {
                var mid = (r - l)/2 + l;
                if(list[mid].Item2 > timestamp)
                {
                    r = mid - 1;
                }
                else
                {
                    l = mid + 1;
                }
            }
            
            if(l-1 < 0) return "";
            if(l-1 >= list.Count) return "";
            return list[l-1].Item1;
        }
        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.Set(key,value,timestamp);
 * string param_2 = obj.Get(key,timestamp);
 */