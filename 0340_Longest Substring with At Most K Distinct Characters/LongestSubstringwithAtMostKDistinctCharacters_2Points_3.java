class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int l = 0, ans = 0;
        for(int r = 0;r<s.length();r++) {
            char c = s.charAt(r);
            map.put(c,r);
            while(map.size() > k) {
                char c_l = s.charAt(l);
                if(map.get(c_l) == l){
                    map.remove(c_l);
                }
                l++;
            }

            ans = Math.max(ans, r-l + 1);
        }
        return ans;
    }
}