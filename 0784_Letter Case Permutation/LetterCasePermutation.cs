public class Solution
    {
        public IList<string> LetterCasePermutation(string s)
        {

            var ans = new List<string>();
            ans.Add("");

            foreach (var c in s)
            {
                var newList = new List<string>();

                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                {
                    foreach (var str in ans)
                    {
                        newList.Add(str + char.ToLower(c));
                        newList.Add(str + char.ToUpper(c));
                    }
                }
                else
                {
                    foreach (var str in ans)
                    {
                        newList.Add(str + c);
                    }
                }
                ans = newList;
            }

            return ans;
        }

    }