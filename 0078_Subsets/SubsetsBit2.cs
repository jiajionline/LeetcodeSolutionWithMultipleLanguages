public class Solution
{
    public IList<IList<int>> Subsets(int[] nums)
    {
        var ans = new List<IList<int>>();
        if (nums == null || nums.Length == 0) return ans;
        var b = Math.Pow(2, nums.Length) - 1;


        for (int i = 0; i <= b; i++)
        {
            var curr = new List<int>();
            var index = -1;
            var k = i;
            while (k > 0)
            {
                index++;
                if ((k & 1) > 0)
                {
                    curr.Add(nums[index]);
                }
                k = (k >> 1);
            }

            ans.Add(curr);
        }

        return ans;
    }
}