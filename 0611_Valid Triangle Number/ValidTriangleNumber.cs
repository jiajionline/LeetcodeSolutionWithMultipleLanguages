public class Solution {
    public int TriangleNumber(int[] nums)
    {
        if (nums == null || nums.Length < 2) return 0;
        nums = nums.OrderByDescending(n => n).ToArray();
        int countOfTriange = 0;
        for(int i = 0; i < nums.Length - 2; i++)
        {
            var c = nums[i];
            var start = i + 1;
            var end = nums.Length - 1;

            while(start < end)
            {
                if(nums[start] + nums[end] > c)
                {
                    countOfTriange += (end - start);
                    start++;
                }else
                {
                    end--;
                }
            }
        }

        return countOfTriange;
    }
}