public class Solution
{
    public int Search(int[] nums, int target)
    {
        if (nums == null || nums.Length == 0) return -1;
        int l = 0, r = nums.Length - 1;
        while (l < r)
        {
            var m = (r - l) / 2 + l;
            if (nums[m] == target) return m;
            if (nums[l] <= nums[m])
            {
                if (target < nums[m] && target >= nums[l])
                {
                    r = m - 1;
                }
                else
                {
                    l = m + 1;
                }
            }
            else
            {
                if (target > nums[m] && target <= nums[r])
                {
                    l = m + 1;
                }
                else
                {
                    r = m - 1;
                }
            }
        }

        return target == nums[l] ? l : -1;

    }
}