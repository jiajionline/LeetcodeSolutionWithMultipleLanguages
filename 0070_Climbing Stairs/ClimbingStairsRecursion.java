class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<Integer,Integer>());
    }
    
    private int climbStairs(int n, Map<Integer,Integer> memo) {
        if(n <= 2) return n;
        if(memo.containsKey(n)) return memo.get(n);
        int v = climbStairs(n-1, memo) + climbStairs(n-2, memo);
        memo.put(n,v);
        return v;
    }
}