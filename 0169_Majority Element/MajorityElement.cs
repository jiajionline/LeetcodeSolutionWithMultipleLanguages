class Solution
{
    public int MajorityElement(int[] nums)
    {
        int current = int.MinValue;
        int count = 0;
        for(int i = 0; i < nums.Length; i++)
        {
            if(count == 0)
            {
                current = nums[i];
                count++;

            }else if(nums[i] == current)
            {
                count++;
            }
            else
            {
                count--;
            }

            if (count > nums.Length / 2) break;
        }

        return current;
    }
}

