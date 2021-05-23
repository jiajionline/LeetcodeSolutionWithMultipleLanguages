public class Solution {
    //Find the smallest l such that arr[l] > arr[l + 1].

    public int PeakIndexInMountainArray(int[] arr) {
        var l = 0;
        var r = arr.Length;
        while(l < r){
            var m = (r-l)/2 + l;
            if(arr[m] > arr[m+1]){
                r = m;
            }else{
                l = m + 1;
            }
        }
        
        return l;
    }
}