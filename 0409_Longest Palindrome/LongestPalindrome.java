class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }

        int ans = 0;
        boolean hasOdd = false;
        for(int v : arr) {
            if(v% 2 == 0) {
                ans+=v;
            }else if(v > 0){
                ans += (v-1);
                hasOdd = true;
            }
        }

        if(hasOdd) ans++;
        return ans;
    }
}