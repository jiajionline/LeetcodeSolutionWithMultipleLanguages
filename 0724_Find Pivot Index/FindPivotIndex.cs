public class Solution {
    public int PivotIndex(int[] nums) {
        if(nums == null || nums.Length <=2) return -1;
        int lCount = 0, rCount = nums.Sum();

        for (int i = 0; i < nums.Length; i++)
        {
            rCount -= nums[i];
            if(lCount == rCount) return i;
            lCount += nums[i];
        }

        return -1;
    }
}