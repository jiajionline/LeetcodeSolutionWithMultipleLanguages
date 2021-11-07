public class Solution {
    public IList<int> SelfDividingNumbers(int left, int right) {
        var ans = new List<int>();
        
        for(int i=left;i<=right;i++)
        {
            var j = i;
            while(j>0)
            {
                var k = j % 10;
                if(k == 0 || (i % k != 0)) break;
                j /= 10;
            }
            
            if(j == 0) ans.Add(i);
        }
        
        return ans;
    }
}