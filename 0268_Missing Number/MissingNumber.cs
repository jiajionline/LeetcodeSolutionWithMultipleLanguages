public class Solution {
   public int MissingNumber(int[] nums) {
       return ((1 + nums.Length) * nums.Length)/2 - nums.Sum();
   }
}