public class Solution {
    public int FourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        var ans = 0;
        var dict = new Dictionary<int,int>();
        
        foreach(var v1 in nums1)
            foreach(var v2 in nums2)
            {
                var sum = v1 + v2;
                if(!dict.ContainsKey(sum)) dict.Add(sum, 0);
                dict[sum]++;
            }
        
        foreach(var v3 in nums3)
            foreach(var v4 in nums4)
            {
                var sum = 0 - (v3 + v4);
                if(dict.ContainsKey(sum))
                    ans += dict[sum];
            }
        
        return ans;
    }
}