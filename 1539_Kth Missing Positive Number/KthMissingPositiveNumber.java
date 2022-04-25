class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length;
        
        while(l < r) {
            int mid = (r-l)/2 + l;
            int v = arr[mid];
            int exp = mid + 1;
            
            if(v - exp >= k) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        
        return l + k;
    }
}