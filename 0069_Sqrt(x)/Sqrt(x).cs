public class Solution
{
    public int MySqrt(int x)
    {
        if (x <= 1) return x;
        for(long i = 0; i <= x; i++)
        {
            if (i * i > x) return (int)i - 1;
        }
        
        return -1;       
    }
}