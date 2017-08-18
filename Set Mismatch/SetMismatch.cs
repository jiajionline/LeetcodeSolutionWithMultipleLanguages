using System;

namespace LeetcodePracticeCsharpVersion
{
    class SetMismatch
    {
        public int[] FindErrorNums(int[] nums)
        {
            int repition = int.MinValue;
            int missing = int.MinValue;

            for(int i = 0; i < nums.Length; i++)
            {
                if(nums[Math.Abs(nums[i]) - 1] < 0)
                {
                    repition = Math.Abs(nums[i]);
                }else
                {
                    nums[Math.Abs(nums[i]) - 1] *= -1;
                }
            }

            for(int i = 0; i < nums.Length; i++)
            {
                if(nums[i] > 0)
                {
                    missing = i+1;
                }
            }

            return new int[] { repition, missing };
        }
    }
}
