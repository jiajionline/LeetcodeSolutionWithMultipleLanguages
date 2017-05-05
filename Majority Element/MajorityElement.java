
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int current = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
        	if(count == 0){
        		current = nums[i];
        		count++;
        	}else if(current == nums[i]){
        		count++;
        	}else{
        		count--;
        	}
        	
        	if(count > nums.length/2) break;
        }
        
        return current;
    }
}
