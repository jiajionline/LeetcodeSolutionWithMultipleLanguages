class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null) return -1;
        if(nums.length == 0) return nums[0];
        int ans = nums[0];
        int c = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == ans){
                c++;
            }else if(c==0){
                ans = nums[i];
            }else{
                c--;
            }
        }
        
        return ans;
    }
}