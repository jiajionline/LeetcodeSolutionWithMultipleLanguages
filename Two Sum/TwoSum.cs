using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetcodePracticeCsharpVersion
{
    class TwoSumQuestion
    {
        public int[] TwoSum(int[] nums, int target)
        {
            var ret = new int[2] { -1, -1 };
            if (nums == null || nums.Length <= 1) return ret;

            Dictionary<int, int> cache = new Dictionary<int, int>();            
            for (int i = 0; i < nums.Length; i++)
            {
                if(cache.ContainsKey(target - nums[i]))
                {
                    ret[0] = cache[target - nums[i]];
                    ret[1] = i;
                    break;
                }
                else
                {
                    if (!cache.ContainsKey(nums[i]))
                    {
                        cache.Add(nums[i], i);
                    }
                }
            }
            return ret;
        }
    }
}
