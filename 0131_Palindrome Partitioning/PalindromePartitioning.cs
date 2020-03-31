public class Solution
    {
        public IList<IList<string>> Partition(string s)
        {
            var ans = new List<IList<string>>();
            if (string.IsNullOrWhiteSpace(s)) return ans;
            BackTracking(ans, new List<string>(), s, 0);
            return ans;
        }

        private void BackTracking(IList<IList<string>> ans, IList<string> list, string str, int s)
        {
            if (s == str.Length)
            {
                ans.Add(new List<string>(list));
                return;
            }

            for (int i = s; i < str.Length; i++)
            {
                if (IsPalindrome(str, s, i))
                {
                    list.Add(str.Substring(s, i - s + 1));
                    BackTracking(ans, list, str, i + 1);
                    list.RemoveAt(list.Count - 1);
                }
            }
        }

        private bool IsPalindrome(string s, int start, int end)
        {
            while (start < end)
            {
                if (s[start++] != s[end--]) return false;
            }

            return true;
        }
    }