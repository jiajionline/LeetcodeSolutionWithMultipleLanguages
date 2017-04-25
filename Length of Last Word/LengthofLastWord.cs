namespace LeetcodePracticeCsharpVersion
{
    class LengthofLastWord
    {
        public int LengthOfLastWord(string s)
        {
            if (s == null || s.Length == 0) return 0;
            int last = s.Length - 1;

            while(last >= 0 && s[last] == ' ')
            {
                last--;
            }
            
            int first = last;
            while(first >= 0 && s[first] != ' ')
            {
                first--;
            }

            return last - first;
        }
    }
}
