class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        
        while(l < r)
        {
            int mid = (r-l)/2 + l;
            if(arr[mid] > arr[mid+1])
                r = mid;
            else
                l = mid+1;
        }
        
        return l;
    }
}