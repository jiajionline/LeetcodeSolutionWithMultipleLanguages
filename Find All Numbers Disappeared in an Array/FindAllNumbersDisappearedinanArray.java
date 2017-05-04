import java.util.*;

public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new LinkedList<Integer>();
        if(nums == null || nums.length == 0) return ret;
        
        for(int i=0;i<nums.length;i++){
        	int index = Math.abs(nums[i]) - 1;
        	if(nums[index] > 0){
        		nums[index] = -nums[index];
        	}
        }
        
        for(int i=0;i<nums.length;i++){
        	if(nums[i] >0){
        		ret.add(i+1);
        	}
        }
        
        return ret;
    }
}
