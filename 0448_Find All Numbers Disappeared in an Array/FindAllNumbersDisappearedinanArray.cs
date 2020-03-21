public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        var ans = new List<int>();
        for(int i=0;i<nums.Length;i++){
            if(nums[Math.Abs(nums[i])-1] > 0){
                nums[Math.Abs(nums[i])-1] = -nums[Math.Abs(nums[i])-1];
            }
        }
        
        for(int i=0;i<nums.Length;i++){
            if(nums[i] > 0){
                ans.Add(i+1);
            }
        }
        
        return ans;
    }
}