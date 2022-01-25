class Solution {
    public boolean validMountainArray(int[] arr) {
        var l = 0;
        while(l < arr.length-1 && arr[l] < arr[l+1]) l++;
        if(l == 0 || l == arr.length-1) return false;
        
        while(l < arr.length-1 && arr[l] > arr[l+1]) l++;
        if(l != arr.length-1) return false;
        return true;
    }
}