using System;
using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    class ContainsDuplicateProblem
    {
        public bool ContainsDuplicate(int[] nums)
        {
            ISet<int> set = new HashSet<int>();
            foreach(var i in nums)
            {
                if (set.Contains(i))
                {
                    return true;
                }
                else
                {
                    set.Add(i);
                }
            }

            return false;
        }
    }
}
