class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int ans = 0, l = 0;
        for(int r = 0;r<s.length();r++) {
            char c = s.charAt(r);
            // You must call the 'remove' function otherwise, the entry (c,r) will not be moved to the last position.
            map.remove(c);
            map.put(c, r);
            if(map.size() > k) {
                char mostLeftCh = map.keySet().iterator().next();
                l = map.get(mostLeftCh) + 1;
                map.remove(mostLeftCh);
            }
           
            ans = Math.max(ans, r - l + 1);
        }
       
        return ans;
    }
}
