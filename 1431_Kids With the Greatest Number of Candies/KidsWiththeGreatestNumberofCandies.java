class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int max = max(candies);
        for(int v : candies){
            ans.add(v + extraCandies >= max);
        }
        return ans;
    }

    private int max(int[] candies) {
        int max = 0;
        for(int v : candies) max = Math.max(max, v);
        return max;
    }
}