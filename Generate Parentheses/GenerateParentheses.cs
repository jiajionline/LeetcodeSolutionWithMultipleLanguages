using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetcodePracticeCsharpVersion
{
    class GenerateParentheses
    {
        public IList<string> GenerateParenthesis(int n)
        {
            IList<string> result = new List<string>();
            RecursiveGeneration("", 0, 0, n, result);
            return result;
        }

        private void RecursiveGeneration(string str, int l , int r, int n, IList<string> result)
        {
            if(l==n && r == n)
            {
                result.Add(str);
                return;
            }

            if (l < n)
            {
                RecursiveGeneration(str + "(", l + 1, r, n, result);
            }

            if(r < l)
            {
                RecursiveGeneration(str + ")", l, r + 1, n, result);
            }
        }
    }
}
