class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return peakIndexInMountainArray(arr, 0, arr.length-1);
    }

    private int peakIndexInMountainArray(int[] arr, int l, int r) {
        if(l == r) return l;
        int mid = (r-l)/2 + l;
        if(arr[mid] > arr[mid+1])
            return peakIndexInMountainArray(arr, l, mid);
        else
            return peakIndexInMountainArray(arr, mid + 1, r);
    }
}