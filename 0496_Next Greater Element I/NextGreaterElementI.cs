public class Solution {
    public int[] NextGreaterElement(int[] nums1, int[] nums2) {
        var stack = new Stack<int>();
        var dictionary = new Dictionary<int,int>();
        
        for(int i=0;i<nums2.Length;i++)
        {
            dictionary.Add(nums2[i],-1);
            while(stack.Count > 0 && stack.Peek() < nums2[i])
            {
                dictionary[stack.Peek()] = nums2[i];
                stack.Pop();
            }
            
            stack.Push(nums2[i]);
        }
        
        for(int i=0;i<nums1.Length;i++)
            nums1[i] = dictionary[nums1[i]];
        
        return nums1;
    }
}