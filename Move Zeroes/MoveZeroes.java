
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <=1) return;
        int copyIndex = 0;
        int currentIndex = 0;
        
        while(currentIndex < nums.length){
        	if(nums[currentIndex] !=0){
        		nums[copyIndex++] = nums[currentIndex];
        	}
        	
        	currentIndex++;
        }
        
        while(copyIndex < nums.length){
        	nums[copyIndex++] = 0;
        }
    }
}
