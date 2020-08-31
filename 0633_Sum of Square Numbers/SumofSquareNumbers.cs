public class Solution {
    public bool JudgeSquareSum(int c)
    {
        {
            int k = (int)Math.Sqrt(c);
            for (int i = 0; i <= k; i++)
            {
                int b = (int)Math.Round((Math.Sqrt(c - i * i)));
                if (i * i + b * b == c) return true;
            }

            return false;
        }
    }
}
