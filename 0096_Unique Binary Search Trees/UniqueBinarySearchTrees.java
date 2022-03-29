class Solution {
    private Map<Integer,Integer> map = new HashMap();
    public int numTrees(int n) {
        if(n <= 1) return 1;
        if(map.containsKey(n)) return map.get(n);
        
        int ans = 0;
        for(int root=1;root<=n;root++) {
            int left = numTrees(root - 1);
            int right = numTrees(n - root);
            ans += left * right;
        }
        
        map.put(n, ans);
        return ans;
    }
}