public class RandomizedSet {
    private Dictionary<int,int> dict;
    private List<int> list;
    private Random r;
    
    public RandomizedSet() {
        dict = new Dictionary<int,int>();
        list = new List<int>();
        r = new Random();
    }
    
    
    public bool Insert(int val) {
        if(!dict.ContainsKey(val))
        {
            list.Add(val);
            dict.Add(val, list.Count - 1);
            return true;
        }
        
        return false;
    }
    
    public bool Remove(int val) {
        if(dict.ContainsKey(val))
        {
            var index = dict[val];
            var lastVal = list[list.Count - 1];
            list[index] = lastVal;
            list.RemoveAt(list.Count - 1);
            dict[lastVal] = index;
            dict.Remove(val);
            return true;
        }
        
        return false;
    }
    
    public int GetRandom() {
        return list[r.Next(list.Count)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * bool param_1 = obj.Insert(val);
 * bool param_2 = obj.Remove(val);
 * int param_3 = obj.GetRandom();
 */