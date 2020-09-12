public class Solution {
    Dictionary<int,int> cache = new Dictionary<int,int>();
    public int ClimbStairs(int n) {
        if(n <= 1) return 1;
        if(cache.ContainsKey(n)) return cache[n];
        var r = ClimbStairs(n-1) + ClimbStairs(n-2);
        cache.Add(n,r);
        return r;
    }
}