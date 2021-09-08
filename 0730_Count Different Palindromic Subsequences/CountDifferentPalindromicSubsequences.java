class Solution {
    private int[][] _mem;
    private static final int KMOD = 1000000007;
    //Recursion with memoization
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        _mem = new int[n][n];
        return count(s.toCharArray(), 0, n-1);
    }

    private int count(char[] arr, int i, int j){
        if(i > j) return 0;
        if(i == j) return 1;
        if(_mem[i][j] > 0) return _mem[i][j];

        long ans = 0;
        if(arr[i] == arr[j]){
            ans += count(arr, i+1, j-1) * 2;
            int l = i+1;
            int r = j-1;
            //find the first char from left in substring equals arr[i]
            while(l <=r && arr[i] != arr[l]) l++;
            //find the first char from right in substring equals arr[i]
            while(l <=r && arr[i] != arr[r]) r--;
            // no char in substring equals to arr[i]
            if(l > r) ans += 2;
            // found only 1 char in substring equals to arr[i]
            else if(l == r) ans +=1;
            // found 2 chars in substring equals to arr[i]
            else ans -= count(arr, l+1, r-1);
        }else{
            ans = count(arr, i, j-1) + count(arr, i+1, j) - count(arr, i+1,j-1);
        }

        _mem[i][j] = (int)((ans + KMOD) % KMOD);
        
        return _mem[i][j];
    }

}