class Solution {
    private Map<String,Integer> map = new HashMap();
    public boolean stoneGame(int[] piles) {
        return getStone(piles, 0, piles.length - 1) > 0;
    }
    
    private int getStone(int[] piles, int l , int r) {
        if(l == r) return piles[l];
        String key = l + "_" + r;
        if(map.containsKey(key)) return map.get(key);
        int ans = Math.max(piles[l] - getStone(piles, l+1, r), piles[r] - getStone(piles, l , r-1));
        map.put(key, ans);
        return ans;
    }
}
