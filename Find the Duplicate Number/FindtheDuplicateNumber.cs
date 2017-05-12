using System;

namespace LeetcodePracticeCsharpVersion
{
    class FindtheDuplicateNumber
    {
        public int FindDuplicate(int[] nums)
        {
            for(int i = 0; i < nums.Length; i++)
            {
                var index = Math.Abs(nums[i]) - 1;
                if (nums[index] < 0)
                {
                    return index + 1;
                }
                else
                {
                    nums[index] = 0 - nums[index];
                }
            }

            return -1;
        }
    }
}
