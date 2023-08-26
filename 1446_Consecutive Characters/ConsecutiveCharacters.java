class Solution {
    public int maxPower(String s) {
        int l = 0, r = 0, ans = 0;
        while(r < s.length()) {
            if(s.charAt(r) == s.charAt(l)){
                r++;
                ans = Math.max(ans, r - l);
            }else{
                l = r;
            }
        }
        return ans;
    }
}