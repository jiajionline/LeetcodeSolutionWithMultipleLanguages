class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int numSquares(int n) {
        if(n == 1) return 1;
        if(map.containsKey(n)) return map.get(n);
        // dp[n] = min(dp[n-j*j] + 1)
        int min = n;
        for(int j = 1; j*j <=n; j++) {
            min = Math.min(min , numSquares(n - j * j) + 1);
        }
        
        map.put(n, min);
        return min;
    }
}