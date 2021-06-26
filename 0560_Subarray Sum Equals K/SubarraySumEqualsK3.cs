public class Solution {
   public int SubarraySum(int[] nums, int k) {       
     
       var count = 0;
       for(int start=0;start<nums.Length;start++)
       {
           var sum = 0;
           for(int end=start;end<nums.Length;end++){
               sum += nums[end];
               if(sum == k) count++;
           }
       }

       return count;
   }
}
