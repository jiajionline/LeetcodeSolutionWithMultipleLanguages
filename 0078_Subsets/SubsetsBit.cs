public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        var ans = new List<IList<int>>();
        if(nums == null || nums.Length == 0) return ans;
        
        for(int i=0;i<(1<<nums.Length);i++){
            var subSet = new List<int>();
            
            for(int b=0;b<nums.Length;b++){
                if(((i >> b) & 1) == 1){
                    subSet.Add(nums[b]);
                }
            }
            
            ans.Add(subSet);
        }

        return ans;
    }
}