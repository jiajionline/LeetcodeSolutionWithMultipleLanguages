class Solution {
    public int longestMountain(int[] arr) {
        if(arr == null || arr.length <= 2) return 0;
        int[] increase = new int[arr.length];
        int[] decrease = new int[arr.length];
        int ans = 0;
        for(int i=1;i<arr.length;i++) {
            if(arr[i] > arr[i-1])
                increase[i] = increase[i-1] + 1;
        }
        
        for(int i=arr.length-2;i>=0;i--) {
            if(arr[i] > arr[i+1])
                decrease[i] =  decrease[i+1] + 1;
        }
        
        for(int i=1; i < arr.length-1;i++) {
            if(increase[i] > 0 &&  decrease[i] > 0)
                ans = Math.max(ans, increase[i] + decrease[i] + 1);
        }
        
        return ans >= 3 ? ans : 0;
    }
}