class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostK(nums, k) - subarraysWithAtMostK(nums, k-1);
    }
    
    public int subarraysWithAtMostK(int[] nums, int k) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int l = 0;
        for(int r=0; r<nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(map.size() > k) {
                if(map.containsKey(nums[l])) {
                    int v = map.get(nums[l]);
                    if(v == 1) 
                        map.remove(nums[l]);
                    else 
                        map.put(nums[l], v-1);
                }
                l++;
            }
            
            ans += r - l + 1;
        }
        
        return ans;
    }
}