
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int currentIndex = 0, nextIndex = 0;
        
        while(nextIndex < nums.length){
        	if(nums[currentIndex] != nums[nextIndex]){
        		currentIndex++;
        		nums[currentIndex] = nums[nextIndex];
        	}
        	
        	nextIndex++;
        }      
        return currentIndex+1;
    }
}
