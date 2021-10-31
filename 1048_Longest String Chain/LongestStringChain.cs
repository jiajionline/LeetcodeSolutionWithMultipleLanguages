 public class Solution
{
    public int LongestStrChain(string[] words)
    {
        Array.Sort(words, (a,b) => a.Length.CompareTo(b.Length));
        var dp = new int[words.Length];
        Array.Fill(dp, 1);

        for (int i = 1; i < words.Length; i++)
        {
            var j = i - 1;

            while (j >= 0)
            {
                if (words[j].Length + 1 < words[i].Length) break;
                if (IsPredecessor(words[j], words[i]))
                    dp[i] = Math.Max(dp[i], dp[j] + 1);

                j--;
            }
        }

        return dp.Max();
    }

    private bool IsPredecessor(string s1, string s2)
    {
        if (s1.Length + 1 != s2.Length) return false;

        var index1 = 0;
        var index2 = 0;

        while (index1 < s1.Length && index2 < s2.Length)
        {
            if (s1[index1] == s2[index2++])
                index1++;
        }

        return index1 == s1.Length;
    }
}