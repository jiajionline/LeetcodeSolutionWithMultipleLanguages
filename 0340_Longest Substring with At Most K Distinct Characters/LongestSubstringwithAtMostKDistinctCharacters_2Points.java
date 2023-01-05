class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, ans = 0;
        for(int r=0;r<s.length();r++) {
            char c = s.charAt(r);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
            if(map.size() <= k) {
                ans = Math.max(ans, r - l + 1);
            }
            
            while(map.size() > k) {
                char lChar = s.charAt(l++);
                if(map.containsKey(lChar)){
                    map.put(lChar, map.get(lChar) - 1);
                    if(map.get(lChar) == 0) map.remove(lChar);
                }
            }
        }
        
        return ans;
    }
}