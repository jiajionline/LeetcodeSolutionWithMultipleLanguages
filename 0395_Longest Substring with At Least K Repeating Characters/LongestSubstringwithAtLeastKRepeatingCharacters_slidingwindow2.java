class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        for(int unique = 1; unique <= 26; unique++) {
            Map<Character, Integer> map = new HashMap<>();
            int left = 0, validCount = 0;
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.get(c) == k) validCount++;
                while(map.size() > unique) {
                    char leftChar = s.charAt(left);
                    if(map.getOrDefault(leftChar, 0) == k) validCount--;
                    map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                    if(map.get(leftChar) == 0) map.remove(leftChar);
                    left++;
                }
                int count = map.size();
                if(count == unique && count == validCount) ans = Math.max(ans, i - left + 1);
            }
        }
        
        return ans;
    }
}