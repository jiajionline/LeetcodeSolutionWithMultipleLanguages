public class Solution {
    public int NumPairsDivisibleBy60(int[] time) {
        var ans = 0;
        var dict = new Dictionary<int,int>();
        
        foreach(var A in time)
        {
            var B = (60 - A % 60) % 60;
            if(dict.ContainsKey(B))
                ans += dict[B];
            if(!dict.ContainsKey(A%60)) dict.Add(A%60,0);
            dict[A%60]+=1;
        }
        
        return ans;
    }
}