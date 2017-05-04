namespace LeetcodePracticeCsharpVersion
{
    class MissingNumberProblem
    {
        public int MissingNumber(int[] nums)
        {
            int ret = 0;
            for(int i = 0; i < nums.Length; i++)
            {
                ret ^= (i + 1);
                ret ^= nums[i];
            }

            return ret;
        }
    }
}
