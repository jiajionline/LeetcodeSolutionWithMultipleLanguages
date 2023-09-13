class Solution {
    public int longestMountain(int[] arr) {
        int ans = 0, l = 0, n = arr.length;
        while(l < n) {
            int r = l + 1;
            if(r < n && arr[l] < arr[r]) {
                while(r+1 < n && arr[r] < arr[r+1]) r++;
                if(r+1 < n && arr[r] > arr[r+1]) {
                    while(r+1 < n && arr[r] > arr[r+1]) r++;
                    ans = Math.max(ans, r-l + 1);
                }
            }
            l = r;
        }
        return ans >= 3 ? ans : 0;
    }
}