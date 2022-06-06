class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            while(!set.add(s.charAt(i))) set.remove(s.charAt(l++));
            ans = Math.max(ans, i - l + 1);
        }
        
        return ans;
    }
}