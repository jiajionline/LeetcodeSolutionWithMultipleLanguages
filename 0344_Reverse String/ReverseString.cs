using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetcodePracticeCsharpVersion
{
    class ReverseStringProblem
    {
        public string ReverseString(string s)
        {
            if (s == null || s.Length <= 1) return s;
            var charArray = s.ToCharArray();
            for(int i = 0; i < charArray.Length / 2; i++)
            {
                var temp = charArray[charArray.Length-1-i];
                charArray[charArray.Length - 1 - i] = charArray[i];
                charArray[i] = temp;                
            }

            return new string(charArray);
        }
    }
}
