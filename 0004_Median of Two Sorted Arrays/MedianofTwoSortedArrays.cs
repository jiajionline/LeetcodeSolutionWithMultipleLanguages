public class Solution {
       public double FindMedianSortedArrays(int[] nums1, int[] nums2)
       {
           int n1 = nums1.Length;
           int n2 = nums2.Length;
           if (n1 > n2) return FindMedianSortedArrays(nums2, nums1);

           int k = (n1 + n2 + 1) / 2;
           int l = 0;
           int r = n1;
           while (l < r)
           {
               var k1 = (r - l) / 2 + l;
               var k2 = k - k1;
               if (nums1[k1] < nums2[k2 - 1])
               {
                   l = k1 + 1;
               }
               else
               {
                   r = k1;
               }
           }

           var m1 = l;
           var m2 = k - l;
	
           var c1 = Math.Max((m1 <= 0 ? int.MinValue : nums1[m1 - 1]), (m2 <= 0 ? int.MinValue : nums2[m2 - 1]));
           if ((n1 + n2) % 2 == 1) return c1;
           var c2 = Math.Min((m1 >= n1 ? int.MaxValue : nums1[m1]), (m2 >= n2 ? int.MaxValue : nums2[m2]));

           return (c1 + c2) * 0.5;

       }
}
