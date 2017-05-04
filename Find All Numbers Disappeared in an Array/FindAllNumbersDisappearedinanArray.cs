using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetcodePracticeCsharpVersion
{
    class FindAllNumbersDisappearedinanArray
    {
        public IList<int> FindDisappearedNumbers(int[] nums)
        {
            var ret = new List<int>();
            if (nums == null || nums.Length == 0) return ret;

            for(int i = 0; i < nums.Length; i++)
            {
                var index = Math.Abs(nums[i]) - 1;
                if(nums[index] > 0)
                {
                    nums[index] = -nums[index];
                }                
            }

            for(int i = 0; i < nums.Length; i++)
            {
                if(nums[i] > 0)
                {
                    ret.Add(i + 1);
                }
            }

            return ret;
        }
    }
}
