using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetcodePracticeCsharpVersion
{
    class DetectCapital
    {
        public bool DetectCapitalUse(string word)
        {
            if (string.IsNullOrWhiteSpace(word)) return false;
            var countCapital = 0;
            var countNonCapital = 0;
            var other = 0;

            foreach(var c in word)
            {
                if(c >= 'A' && c <= 'Z')
                {
                    countCapital++;
                }else if(c >= 'a' && c <= 'z')
                {
                    countNonCapital++;
                }
                else
                {
                    other++;
                }
            }

            if(other > 0)
            {
                return false;
            }
           
            if(countNonCapital == word.Length || countCapital == word.Length)
            {
                return true;
            }

            if(word[0] >= 'A' && word[0] <= 'Z' && countNonCapital == word.Length - 1)
            {
                return true;
            }

            return false;
        }
    }
}
