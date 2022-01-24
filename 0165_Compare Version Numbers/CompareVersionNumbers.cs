public class Solution {
    public int CompareVersion(string version1, string version2) {
        var ver1 = Convert(version1.Split('.'));
        var ver2 = Convert(version2.Split('.'));
        var m = 0;
        var n = 0;
        
        while(m < ver1.Count && n < ver2.Count)
        {
            if(ver1[m] > ver2[n]) return 1;
            else if(ver1[m] < ver2[n]) return -1;
            else{
                m++;
                n++;
            }
        }
        
        if(m < ver1.Count) return 1;
        if(n < ver2.Count) return -1;
        return 0;
        
    }
    
    private List<int> Convert(string[] splits)
    {
        var list = new List<int>();
        for(int i=splits.Length-1;i>=0;i--)
        {
            var v = int.Parse(splits[i]);
            if(v!=0 || (v == 0 && list.Count > 0)) list.Insert(0, v);
        }
        
        if(list.Count == 0) list.Add(0);
        return list;
    }
}