public class Solution {
    public IList<IList<int>> FourSum(int[] nums, int target) {
        var ans = new List<IList<int>>();
        if(nums == null || nums.Length <4) return ans;
        
        Array.Sort(nums);
        
        for(int i=0;i<nums.Length - 3;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<nums.Length - 2;j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                var s = j+1;
                var e = nums.Length - 1;
                while(s < e){
                    var v = nums[i] + nums[j] + nums[s] + nums[e];
                    if(v == target){
                        ans.Add(new int[]{nums[i],nums[j],nums[s],nums[e]});
                        while(s < e && nums[s] == nums[s+1]) s++;
                        while(s < e && nums[e] == nums[e-1]) e--;
                    
                        s++;
                        e--;
                    }else if(v < target){
                        s++;
                    }else{
                        e--;
                    }
                    
                }
            }
        }
        
        return ans;
    }
}