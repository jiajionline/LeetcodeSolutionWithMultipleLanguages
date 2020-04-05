public class Solution
{
    public int FirstUniqChar(string s)
    {
        if (s == null || s.Length == 0) return -1;
        if (s.Length == 1) return 0;

        int[] letterToCount = new int[26];
        foreach(var c in s)
        {
            letterToCount[c - 'a']++;
        }

        for(int i =0;i<s.Length;i++)
        {
            if(letterToCount[s[i] - 'a'] == 1)
            {
                return i;
            }
        }

        return -1;
    }
}

