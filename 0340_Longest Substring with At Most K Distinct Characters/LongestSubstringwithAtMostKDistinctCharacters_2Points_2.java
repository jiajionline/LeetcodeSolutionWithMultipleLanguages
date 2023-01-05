class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int ans = 0, left = 0;
        for(int r = 0;r<s.length();r++) {
            char c = s.charAt(r);
            map.remove(c);
            map.put(c, r);
            if(map.size() > k) {
                char mostLeftCh = map.keySet().iterator().next();
                left = map.get(mostLeftCh) + 1;
                map.remove(mostLeftCh);
            }
            
            ans = Math.max(ans, r - left + 1);
        }
        
        return ans;
    }
}