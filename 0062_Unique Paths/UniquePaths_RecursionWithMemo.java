class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePaths(m,n, new HashMap<String,Integer>());
    }
    
    private int uniquePaths(int m, int n, Map<String,Integer> memo) {
        if(m == 1 || n == 1) return 1;
        String key = m + "_" + n;
        if(memo.containsKey(key)) return memo.get(key);
        int v = uniquePaths(m-1,n,memo) + uniquePaths(m,n-1,memo);
        memo.put(key, v);
        return v;
    }
}