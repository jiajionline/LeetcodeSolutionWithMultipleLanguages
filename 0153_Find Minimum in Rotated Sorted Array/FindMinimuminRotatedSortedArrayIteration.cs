public class Solution
{
    public int FindMin(int[] nums)
    {
        if (nums.Length == 1) return nums[0];
        if (nums.Length == 2) return Math.Min(nums[0], nums[1]);

        int l = 0;
        int r = nums.Length - 1;

        while (nums[l] > nums[r])
        {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > nums[r])
            {
                l = mid + 1;
            }
            else
            {
                r = mid;
            }
        }

        return nums[l];
    }
}