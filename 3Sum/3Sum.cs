using System;
using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    class ThreeSumQuestion
    {
        public IList<IList<int>> ThreeSum(int[] nums)
        {
            IList<IList<int>> ret = new List<IList<int>>();

            if (null == nums || nums.Length <= 2) return ret;
            Array.Sort(nums);
            ISet<string> uniqueResultSet = new HashSet<string>();

            for(int i = 0; i < nums.Length - 1; i++)
            {
                int a1 = nums[i];
                int left = i+1;
                int right = nums.Length - 1;

                //initially, the last test case failed if the array contains too many repeatable elements like [0,0,....0]
                //here to skip duplicate elements to reduce executive time
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                while (left < right)
                {
                    if(a1 + nums[left] + nums[right] == 0)
                    {
                        var str = string.Format("{0}{1}{2}", a1, nums[left], nums[right]);
                        if (!uniqueResultSet.Contains(str))
                        {
                            ret.Add(new List<int>() { a1, nums[left], nums[right] });
                            uniqueResultSet.Add(str);                          
                        }
                        left++;
                        right--;
                    }
                    else if(a1 + nums[left] + nums[right] < 0)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }

            }

            return ret;
        }
    }
}
