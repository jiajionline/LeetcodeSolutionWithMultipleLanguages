public class Solution {
    public int MinOperations(int[] nums1, int[] nums2) {
        var ans = 0;
        var m = nums1.Length;
        var n = nums2.Length;
        
        if(Math.Min(m,n) * 6 < Math.Max(m,n) * 1) return -1;
        var sum1 = nums1.Sum();
        var sum2 = nums2.Sum();
        if(sum1 == sum2) return 0;
        if(sum1 > sum2) return MinOperations(nums2, nums1);
        
        Array.Sort(nums1);
        Array.Sort(nums2, (a,b) => b-a);
        
        var p1 = 0;
        var p2 = 0;
        
        while(sum1 != sum2)
        {
            var diff = sum2 - sum1;
            var d1 = p1 == m ? 0 : 6 - nums1[p1];
            var d2 = p2 == n ? 0 : nums2[p2] - 1;
            var change = Math.Min(diff, Math.Max(d1,d2));
            
            if(d1 >= d2)
            {
                sum1 += change;
                p1++;
            }else {
                sum2 -= change;
                p2++;
            }
            
            ans++;
        }
        
        return ans;
    }
}