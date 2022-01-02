class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if(time == null || time.length <= 1) return 0;
        int ans = 0;
       
        int[] mods = new int[60];
        
        for(int v : time) {
            int mod = (60 - v % 60) % 60;
            ans += mods[mod];
            mods[v % 60]++;
        }
        
        return ans;
    }
}