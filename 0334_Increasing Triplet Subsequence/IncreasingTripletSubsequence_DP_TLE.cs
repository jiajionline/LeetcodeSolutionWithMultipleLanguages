public class Solution {
    public bool IncreasingTriplet(int[] nums) {
        if(nums == null || nums.Length <=2 ) return false;
        int n = nums.Length;
        
        int min = Int32.MaxValue;
        int max = Int32.MaxValue;
        
        for(int i=0;i<n;i++){
            if(nums[i] > max) return true;
            
            if(min > nums[i]){
                min = nums[i];    
            }else if(nums[i] > min && nums[i] < max){
                max = nums[i];
            }
        }
        
        return false;
    }
}