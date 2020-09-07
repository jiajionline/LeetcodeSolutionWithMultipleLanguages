public class Solution
{
    public int NumWays(string s)
    {
        int mod = 1_000_000_007;
        long len = s.Length;
        var countOfOne = s.Where(c => c == '1').Count();
        if (countOfOne % 3 != 0) return 0;
        if (countOfOne == 0) return (int)(((len - 1) * (len - 2) / 2) % mod);
        countOfOne /= 3;
        long l = 0;
        long r = 0;
        long c = 0;
        for (int i = 0; i < s.Length; i++)
        {
            if (s[i] == '1') c += 1;
            if (c == countOfOne)
            {
                l += 1;
            }
            else if (c == countOfOne * 2)
            {
                r += 1;
            }
        }

        return (int)((l * r) % mod);
    }
}