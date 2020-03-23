class Solution {
    public int jump(int[] nums) {
        
        int ans = 0;
        int furthestPos = 0;
        int currend = 0;

        for(int i=0;i<nums.length-1;i++){
            if(i+nums[i] > furthestPos){
                furthestPos = i + nums[i];
            }

            if(i == currend){
                ans++;
                currend = furthestPos;
            }
        }

        return ans;
    }
}