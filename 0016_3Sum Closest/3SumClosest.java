class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        int ansTarget = Math.abs(target - (nums[0] + nums[1] + nums[2]));
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++)
        {
            int l = i+1;
            int r = nums.length - 1;
            while(l < r)
            {
                var sum = nums[i] + nums[l] + nums[r];
                if(sum == target)
                    return sum;
                else{
                    if(Math.abs(sum - target) < ansTarget)
                    {
                        ans = sum;
                        ansTarget = Math.abs(sum - target);
                    }
                    if(sum > target) r--;
                    else l++;
                }
            }
        }
        
        return ans;
    }
}