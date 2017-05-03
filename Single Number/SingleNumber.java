
public class SingleNumber {
    public int singleNumber(int[] nums) {
    	int ret = 0;
        for(int i : nums){
        	ret ^= i;
        }
        
        return ret;
    }
}
