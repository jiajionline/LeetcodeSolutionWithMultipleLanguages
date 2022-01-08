public class Solution {
    public IList<IList<int>> Generate(int numRows) {
        var ans = new List<IList<int>>();
        
        var list = new List<int>();
        list.Add(1);
        ans.Add(list);
        for(int i=1;i<numRows;i++)
        {
            if(ans.Count == i)
                ans.Add(new List<int>());
            
            var prevList = ans[i-1];
            var currList = ans[i];
            
            var count = prevList.Count + 1;
            for(int j=0;j< count ;j++)
            {
                if(j == 0){
                    currList.Add(prevList[j]);
                }else if(j+1 == count) {
                    currList.Add(prevList[j-1]);
                }else {
                    currList.Add(prevList[j-1] + prevList[j]);
                }
            }
        }
        
        return ans;
    }
}