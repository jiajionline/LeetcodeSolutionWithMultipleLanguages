class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            Set<Integer> set = new HashSet<Integer>();
            for(int j=i;j<nums.length;j++) {
                set.add(nums[j]);
                if(set.size() == k){
                    ans++;
                }
                
                if(set.size() > k) break;
            }
        }
        
        return ans;
    }
}