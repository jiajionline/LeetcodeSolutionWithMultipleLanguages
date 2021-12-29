public class Solution {
    public int Rob(int[] nums) {
        var n = nums.Length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.Max(nums[0],nums[1]);
        
        return Math.Max(Rob(nums, nums[0], nums[0], 2,n-1), Rob(nums, 0, nums[1],2,n));
       
    }

    private int Rob(int[] nums, int previous, int current, int start, int end){
        for(int i=start;i<end;i++){
            int next = Math.Max(current, previous + nums[i]);
            previous = current;
            current = next;
        }       

        return current;
    }
}