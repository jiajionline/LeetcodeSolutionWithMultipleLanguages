public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        var ans = new List<IList<int>>();
        ans.Add(new List<int>());
        
        foreach(var v in nums){
            int count = ans.Count;
            for(int i=0;i<count;i++){
                var subSet = new List<int>(ans[i]);
                subSet.Add(v);
                ans.Add(subSet);
            }
        }
        
        return ans;
    }
}