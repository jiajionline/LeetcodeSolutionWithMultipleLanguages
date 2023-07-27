class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length(), ans = 0;
        int[] map = new int[26];
        for(int len=k;len<=n;len++) {
            for(int l=0;l+len<=n;l++) {
                int r = l + len - 1;
                Arrays.fill(map,0);
                for(int i=l;i<=r;i++) {
                    map[s.charAt(i)-'a']++;
                }
                if(validate(map,k)) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        return ans;
    }

    private boolean validate(int[] map, int k) {
        for(int v : map){
            if(v > 0 && v < k) return false;
        }
        return true;
    }
}