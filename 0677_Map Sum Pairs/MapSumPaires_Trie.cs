public class MapSum {
    private Trie root = new Trie(0);
    private Dictionary<string,int> dict = new Dictionary<string,int>();
    
    /** Initialize your data structure here. */
    public MapSum() {
        
    }
    
    public void Insert(string key, int val) {
        
        var offset = val;
        if(dict.ContainsKey(key)){
            offset -= dict[key];
            dict[key] = val;
        }else{
            dict.Add(key, val);
        }
        
        
        var p = root;
        foreach(var c in key)
        {
            if(p.Next[c - 'a'] == null) 
                p.Next[c - 'a'] = new Trie(offset);
            else
                p.Next[c - 'a'].Value += offset;
            
            p = p.Next[c - 'a'];
        }
    }
    
    public int Sum(string prefix) {
        
        var p = root;
        int sum = 0;
        foreach(var c in prefix)
        {
            if(p.Next[c - 'a'] != null){
                p = p.Next[c - 'a'];
                sum = p.Value;
            }else{
                sum = 0;
                break;
            }
        }
        
        return sum;
    }
}

public class Trie {
    public Trie(int v){
        this.Value = v;
    }
    public Trie[] Next = new Trie[26];
    public int Value = 0;
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.Insert(key,val);
 * int param_2 = obj.Sum(prefix);
 */