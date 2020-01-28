public class Solution
{
    public int MySqrt(int x)
    {
        long k = x;
        long l = 0;
        long r = k + 1;
        while (l < r)
        {
            long m = l + (r - l) / 2;
            if (m*m > k)
            {
                r = m;
            }
            else
            {
                l = m + 1;
            }
        }

        return (int)l - 1;
    }
}