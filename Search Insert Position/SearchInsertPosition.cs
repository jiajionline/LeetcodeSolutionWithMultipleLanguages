namespace LeetcodePracticeCsharpVersion
{
    class SearchInsertPosition
    {
        public int SearchInsert(int[] nums, int target)
        {
            if (nums == null || nums.Length == 0) return 0;
            if (target <= nums[0]) return 0;
            if (target > nums[nums.Length - 1]) return nums.Length;

            int start = 0;
            int end = nums.Length - 1;
            while(start <= end)
            {
                int mid = (end - start) / 2 + start;
                if(target == nums[mid])
                {
                    return mid;
                }else if(target < nums[mid])
                {
                    if (mid - 1 >= 0 && target > nums[mid - 1])
                        return mid;
                    end = mid;
                }
                else
                {
                    if (mid + 1 <= nums.Length - 1 && target < nums[mid + 1]) return mid+1;
                    start = mid+1;
                }
            }

            return 0;

        }
    }
}
