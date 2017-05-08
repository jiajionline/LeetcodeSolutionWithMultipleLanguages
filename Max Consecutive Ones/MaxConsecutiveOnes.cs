using System;

namespace LeetcodePracticeCsharpVersion
{
    class MaxConsecutiveOnes
    {
        public int FindMaxConsecutiveOnes(int[] nums)
        {
            int max = 0;
            int currentCount = 0;
            foreach(var v in nums)
            {
                if(v == 1)
                {
                    currentCount++;
                    max = Math.Max(currentCount, max);
                }
                else
                {
                    currentCount = 0;
                }
            }

            return max;
        }
    }
}
