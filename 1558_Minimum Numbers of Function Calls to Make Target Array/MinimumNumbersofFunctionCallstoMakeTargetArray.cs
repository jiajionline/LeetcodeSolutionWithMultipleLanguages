public class Solution {
    public int MinOperations(int[] nums) {
        var countOf1 = 0;
        var highest = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            var h = -1;
            var x = nums[i];
            while(x !=0){
                countOf1 += (x & 1);
                x >>= 1;
                h++;
            }
            highest = Math.Max(h, highest);
        
        }
        return countOf1 + highest;
    }
}