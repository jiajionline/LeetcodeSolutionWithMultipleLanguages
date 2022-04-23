class Solution {
    public int longestMountain(int[] arr) {
        int inc = 0;
        int dec = 0;
        int ans = 0;
        for(int i=1; i< arr.length; i++) {
            if(dec > 0 && arr[i] > arr[i-1] || arr[i] == arr[i-1])
                dec = inc = 0;
            
            inc += arr[i] > arr[i-1] ? 1 : 0;
            dec += arr[i] < arr[i-1] ? 1 : 0;
            if(inc > 0 && dec > 0)
                ans = Math.max(ans, inc + dec + 1);
        }
        
        return ans >= 3 ? ans : 0;
    }
}