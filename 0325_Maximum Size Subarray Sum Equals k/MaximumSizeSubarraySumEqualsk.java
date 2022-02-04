class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0, -1);
        int presum = 0;
        //calculate presum
        for(int i=0;i<n;i++) {
            presum += nums[i];
            if(map.containsKey(presum - k)) {
                ans = Math.max(ans, i - map.get(presum - k));
            }
            
            if(!map.containsKey(presum)) map.put(presum, i);
        }
            
        
        return ans;
    }
}