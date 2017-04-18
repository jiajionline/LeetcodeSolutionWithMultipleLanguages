import java.util.*;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		ret[0] = -1;
		ret[1] = -1;
		if(nums == null || nums.length <= 1) return ret;
		
        Map<Integer,Integer> cache = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	if(cache.containsKey(target - nums[i])){
        		ret[0] = cache.get(target - nums[i]);
        		ret[1] = i;
        		break;
        	}else{
        		if(!cache.containsKey(nums[i]))
        			cache.put(nums[i], i);
        	}
        }
        
        return ret;
    }
}
