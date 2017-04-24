namespace LeetcodePracticeCsharpVersion
{
    class RemoveElementProblem
    {
        public int RemoveElement(int[] nums, int val)
        {
            if (nums == null || nums.Length == 0) return 0;
            int currentIndex = -1;
            int nextIndex = 0;
            while(nextIndex < nums.Length)
            {
                if(nums[nextIndex] != val)
                {
                    currentIndex++;
                    nums[currentIndex] = nums[nextIndex];
                }
                nextIndex++;
            }
            return currentIndex + 1;
        }
    }
}
