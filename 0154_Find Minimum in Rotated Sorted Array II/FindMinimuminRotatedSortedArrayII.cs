public class Solution
{
    public int FindMin(int[] nums)
    {
        if (nums == null || nums.Length == 0) return int.MinValue;
        return FindMin(nums, 0, nums.Length - 1);   
    }

    private int FindMin(int[] nums, int start, int end)
    {
        if (start + 1 >= end) return Math.Min(nums[start], nums[end]);
        // Notice, we can't put equal here, if yes, it doesn't satisfy the duplicated case. Interesting thing is the solution is as the same as 153
        if (nums[start] < nums[end])
        {
            return nums[start];
        }

        int mid = (end - start) / 2 + start;
        return Math.Min(FindMin(nums, start, mid-1), FindMin(nums, mid, end));

    }
}