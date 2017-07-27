using System;

namespace LeetcodePracticeCsharpVersion
{
    class ArrayPartitionI
    {
        public int ArrayPairSum(int[] nums)
        {
            int sum = 0;
            Array.Sort(nums);
            var index = 0;
            while(index < nums.Length)
            {
                sum += nums[index];
                index += 2;
            }

            return sum;
        }
    }
}
