class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if(calories == null || calories.length < k) return 0;
        int total = 0;
        for(int i=0;i<k;i++) {
            total += calories[i];
        }
        
        int score = total > upper ? 1 : (total < lower ? -1 : 0);
        for(int i=k;i<calories.length;i++) {
            total -= calories[i-k];
            total += calories[i];
            score += (total > upper ? 1 : (total < lower ? -1 : 0));
        }
        
        return score;
    }
}