public class Solution
{
    public int ThreeSumClosest(int[] num, int target)
    {
        int ans = num[0] + num[1] + num[num.Length - 1];
        Array.Sort(num);
        for (int i = 0; i < num.Length - 2; i++)
        {
            int start = i + 1, end = num.Length - 1;
            while (start < end)
            {
                int sum = num[i] + num[start] + num[end];
                if (sum > target)
                {
                    end--;
                }
                else
                {
                    start++;
                }
                if (Math.Abs(sum - target) < Math.Abs(ans - target))
                {
                    ans = sum;
                }

                if (ans == target) return ans;
            }
        }
        return ans;
    }
}
