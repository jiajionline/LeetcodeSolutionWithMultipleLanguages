
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        if(target <= nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
        	int mid = (end - start)/2 + start;
        	if(nums[mid] == target) 
        		return mid;
        	else if(target < nums[mid]){
        		if(mid - 1 >=0 && target > nums[mid-1]) 
        			return mid;
        		end = mid;
        	}else{
        		if(mid + 1 <= nums.length - 1 && target < nums[mid + 1]) 
        			return mid+1;
        		start = mid+1;
        	}
        }
        
        return 0;
    }
}
