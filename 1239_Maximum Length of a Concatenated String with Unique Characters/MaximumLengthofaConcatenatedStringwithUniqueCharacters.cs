public class Solution {
    public int MaxLength(IList<string> arr) {
        var list = new List<string>();
        foreach(var s in arr)
        {
            if(IsUnique(s)) list.Add(s);
        }

        var n = (1 << list.Count);
        var ans = 0;
        for(int i=1;i<n;i++)
        {
            var k = i;
            var index = 0;
            var sb = new StringBuilder();
            while(k > 0)
            {
                if((k & 1) == 1)
                    sb.Append(list[index]);
                
                index++;
                k >>= 1;
            }
            
            var finalStr = sb.ToString();
            if(IsUnique(finalStr))
            ans = Math.Max(ans, finalStr.Length);
        }
        
        return ans;
    }

    private bool IsUnique(string str)
    {
        var unique = 0;
        foreach(var c in str)
        {
            if(((1 << (c - 'a')) & unique) > 0) return false;
            unique = ((1 << (c - 'a')) | unique);
        }

        return true;
    }
}