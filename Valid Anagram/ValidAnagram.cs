using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    class ValidAnagram
    {
        public bool IsAnagram(string s, string t)
        {
            if (s.Length != t.Length) return false;
            IDictionary<char, int> dict = new Dictionary<char, int>();
            foreach(var c in s)
            {
                if (dict.ContainsKey(c))
                {
                    dict[c] = dict[c] + 1;
                }
                else
                {
                    dict[c] = 1;
                }
            }

            foreach(var c in t)
            {
                if (dict.ContainsKey(c))
                {
                    dict[c] = dict[c] - 1;
                }
                else
                {
                    return false;
                }
            }

            var values = dict.Values;
            foreach(var k in values)
            {
                if (k != 0) return false;
            }

            return true;
        }
    }
}
