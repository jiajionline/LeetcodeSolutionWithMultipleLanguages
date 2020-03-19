public class Solution {
    public bool ContainsNearbyDuplicate(int[] nums, int k) {
        var dict = new Dictionary<int,int>();
        for(int i=0;i<nums.Length;i++){
            var v = nums[i];
            if(dict.ContainsKey(v)){
                if(i - dict[v] <= k) return true;
            }
            
            dict[v] = i;
        }
        
        return false;
    }
}