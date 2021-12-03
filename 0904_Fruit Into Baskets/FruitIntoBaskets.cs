public class Solution {
    public int TotalFruit(int[] fruits) {
        var ans = 0;
        // type of fruit -> count
        var dict = new Dictionary<int,int>();
        var l = 0;
        var r = 0;
        
        while(r < fruits.Length)
        {
            if(!dict.ContainsKey(fruits[r])) dict.Add(fruits[r],0);
            dict[fruits[r]]++;
            r++;
            
            if(dict.Count <= 2) ans = Math.Max(ans, r -l);
        
            while(dict.Count > 2)
            {
                if(dict.ContainsKey(fruits[l]))
                {
                    dict[fruits[l]]--;
                    if(dict[fruits[l]] == 0) dict.Remove(fruits[l]);
                }
                l++;
            }   
        }
        
        return ans;
    }
}