public class Solution {
    public IList<IList<int>> CombinationSum3(int k, int n) {
        var ans = new List<IList<int>>();
        
        for(int i=0;i<(1<<9);i++)
        {
            var list = new List<int>();
            var sum = 0;
            var countOf1 = 0;
            for(var j=1;j<=9;j++)
            {
                if((i & (1 << (j-1))) > 0)
                {
                    sum+=j;
                    countOf1++;
                    list.Add(j);
                }
                
                if(countOf1 > k) break;
            }
            
            if(countOf1 == k && sum == n)
            {
                ans.Add(list);
            }
        }
        
        return ans;
    }
}