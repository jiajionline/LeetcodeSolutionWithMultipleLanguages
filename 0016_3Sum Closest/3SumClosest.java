class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<n-2;i++) {
            int l = i+1, r = n - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target) return target;
                else if(sum > target) r--;
                else l++;
                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }    
            }
        }
        
        return ans;
    }
}