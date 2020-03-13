public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        var ans = new List<IList<int>>();
        if(nums == null || nums.Length <=2) return ans;
        Array.Sort(nums);
        
        for(int i=0;i<nums.Length - 2;i++){
            
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            int l = i+1;
            int r = nums.Length - 1;
            
            var start = i+1;
            var end = nums.Length - 1;
            var sum = 0 - nums[i];
            
            while(l < r){
                if(nums[l] + nums[r] == sum){
                    ans.Add(new int[]{nums[i], nums[l], nums[r]});
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }else if(nums[l] + nums[r] > sum){
                    r--;
                }else{
                    l++;
                }
            }
        }
        
        return ans;
    }
}