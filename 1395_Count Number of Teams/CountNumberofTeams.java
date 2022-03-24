class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        for(int i=0;i<rating.length;i++) {
            int l = 0;
            int r = 0;
            for(int j=0;j<i;j++) {
                if(rating[j] < rating[i]) l++;
            }
            
            for(int j=i+1;j<rating.length;j++) {
                if(rating[i] < rating[j]) r++;
            }
            
            ans += (l * r + (i-l) * (rating.length-i-r-1));
        }
        
        return ans;
    }
}