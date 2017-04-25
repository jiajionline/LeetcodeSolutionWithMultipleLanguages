using System;
namespace LeetcodePracticeCsharpVersion
{
    class MaximumSubarray
    {
        public int MaxSubArray(int[] nums)
        {
            if (nums.Length == 1) return nums[0];
            int currentMax = nums[0];
            int lastMax = nums[0];

            for(int i = 1; i < nums.Length; i++)
            {
                if (lastMax < 0)
                {
                    lastMax = nums[i];
                }
                else
                {
                    lastMax += nums[i];
                }

                currentMax = Math.Max(lastMax, currentMax);
            }

            return currentMax;
        }
    }
}
