public class Solution {
    public int FindKthLargest(int[] nums, int k) {
        return FindKthLargest(nums, 0, nums.Length-1, nums.Length - k);
    }
    
    private int FindKthLargest(int[] nums, int start, int end, int k)
    {
        if (start > end) return int.MaxValue;
        
        var pivot = nums[end];
        var left = start;
        for(int i=start;i<end;i++)
        {
            if(nums[i] <= pivot){
                Swap(nums, left++, i);
            }
        }
        
        Swap(nums, left, end);
        
        if(left == k) 
            return nums[left];
        else if(left < k) //check right part
            return FindKthLargest(nums, left+1, end, k);
        else
            return FindKthLargest(nums, start, left-1, k);
    }
    
    private void Swap(int[] nums, int A, int B)
    {
        var tmp = nums[A];
        nums[A] = nums[B];
        nums[B] = tmp;
    }
}
