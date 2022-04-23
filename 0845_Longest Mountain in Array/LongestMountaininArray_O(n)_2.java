class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int ans = 0 , l = 0 , r = 0;
        // check if out of boundary, the range must >= 3
        while(l + 2 < n) {
            r = l + 1;
            if(arr[l] < arr[r]) {
                // check if r+1 satisfy 
                while(r + 1 < n && arr[r] < arr[r+1]) r++;
                if(r+1 < n && arr[r] > arr[r+1]) {
                    while(r + 1 < n && arr[r] > arr[r+1]) r++;
                    ans = Math.max(ans, r - l + 1);
                }
            }
            l = r;
        }
        
        return ans;
    }
}