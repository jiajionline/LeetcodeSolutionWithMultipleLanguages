
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int currentMax = nums[0];
        int lastMax = nums[0];
        
        for(int i=1;i<nums.length;i++){
        	if(lastMax < 0){
        		lastMax = nums[i];
        	}else{
        		lastMax += nums[i];        		
        	}
        	currentMax = Math.max(currentMax, lastMax);
        }
        
        return currentMax;
    }
}
