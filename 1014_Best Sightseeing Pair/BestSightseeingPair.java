class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int currMax = values[0];
        
        for(int j=1;j<values.length;j++) {
            ans = Math.max(ans, currMax + values[j] - j);
            currMax = Math.max(currMax, values[j] + j);
        }
        
        return ans;
    }
}