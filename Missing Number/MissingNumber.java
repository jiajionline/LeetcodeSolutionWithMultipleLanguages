
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int ret = 0;
        for(int i=0;i<nums.length;i++){
        	ret ^= (i+1);
        	ret ^= nums[i];
        }
        
        return ret;
    }
}
