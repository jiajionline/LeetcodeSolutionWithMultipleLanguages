class Solution {
    public long appealSum(String s) {
        int n = s.length();
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        
        long ans = 0;
        
        for(int i=0; i< n;i++) {
            ans += (i - pos[s.charAt(i) - 'a']) * (n - i);
            pos[s.charAt(i) - 'a'] = i;
        }

        
        return ans;
    }
}