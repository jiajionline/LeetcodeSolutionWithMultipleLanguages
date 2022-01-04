public class Solution {
    public int SingleNumber(int[] nums)
    {
        var ans = 0;

        for (int i = 0; i < 32; i++)
        {
            var count1 = 0;
            foreach (var n in nums)
            {
                count1 += (n >> i) & 1;
            }

            ans += ((count1 % 3) << i);
        }

        return ans;
    }
}