class Solution {
    public int characterReplacement(String s, int k) {
        int[] counter = new int[26];
        int left = 0, ans = 0;
        
        for(int i=0;i<s.length();i++) {
            counter[s.charAt(i) - 'A']++;
            while(i - left + 1 - findMax(counter) > k) {
                counter[s.charAt(left++) - 'A']--;
            }
            
            ans = Math.max(ans, i - left + 1);
        }
        
        return ans;
    }
    
    private int findMax(int[] counters) {
        return Arrays.stream(counters).max().getAsInt();
    }
}