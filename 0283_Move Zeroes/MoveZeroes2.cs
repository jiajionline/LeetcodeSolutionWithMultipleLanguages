public class Solution {
   public void MoveZeroes(int[] nums) {
       if(nums == null || nums.Length <= 1) return;
       var start = 0;
       var end = 0;
       while(end < nums.Length)
       {
           if(nums[end] == 0) end++;
           else{
               nums[start++] = nums[end++];
           }
       }

       for(int i=start;i<nums.Length;i++)
           nums[i] = 0;
   }
}
