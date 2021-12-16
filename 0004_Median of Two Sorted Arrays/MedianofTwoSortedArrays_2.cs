public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {        
        var arr = nums1.Concat(nums2).ToList();
        arr.Sort();
        
        var size = arr.Count();
        var isOdd =  size % 2 != 0;
        double median; 
        
        if(isOdd)
            return median = arr[size / 2];        
        
        return median = (arr[(size / 2)-1] + arr[(size / 2)]) / 2.0;
                       
    }
}