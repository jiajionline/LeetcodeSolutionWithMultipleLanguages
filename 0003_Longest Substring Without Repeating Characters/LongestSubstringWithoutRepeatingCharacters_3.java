class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] arr = new int[128];
        int l = 0;
        int ans = 0;
        for(int r=0;r<s.length();r++) {
            char c = s.charAt(r);
            if(arr[c] == 0) {
                arr[c]++;
                ans = Math.max(ans, r - l + 1);   
            }else {
                while(s.charAt(l) != c) {
                    arr[s.charAt(l++)]--;
                }
                
                l++;
            }
        }
        
        return ans;
    }
}