class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] - (i+1) >= k) return i + k;
        }
        
        return arr.length + k;
    }
}