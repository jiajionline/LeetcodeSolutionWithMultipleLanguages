
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int currentIndex = -1;
        int nextIndex = 0;
        
        while(nextIndex < nums.length){
        	if(nums[nextIndex] != val){
        		currentIndex++;
        		nums[currentIndex] = nums[nextIndex];
        	}
        	nextIndex++;
        }
        
        return currentIndex+1;
    }
}
