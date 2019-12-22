public class Solution {
    public int ArrayPairSum(int[] nums) {
        Array.Sort(nums);
        int ans = 0;
        for(int i=0;i<nums.Length;i=i+2){
            ans += nums[i];
        }
        return ans;
    }
}