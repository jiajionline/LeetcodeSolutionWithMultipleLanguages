class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return getScore(nums, 0, nums.length-1, new HashMap<String, Integer>()) >= 0;
    }
    
    private int getScore(int[] nums, int l , int r, HashMap<String, Integer> cache) {
        
        if(l == r) return nums[l];
        String key = l + "_" + r;
        if(cache.containsKey(key)) return cache.get(key);
        
        int score = Math.max(nums[l] - getScore(nums, l+1,r, cache), nums[r] - getScore(nums, l, r-1, cache));
        cache.put(key, score);
        return score;
    }
}