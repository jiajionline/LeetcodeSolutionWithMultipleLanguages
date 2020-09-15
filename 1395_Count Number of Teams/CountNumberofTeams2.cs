public class Solution {
    public int NumTeams(int[] rating) {
        var ans = 0;
        for(int i=0;i<rating.Length;i++){
            var l =0;
            var r = 0;
            for(int j=0;j<i;j++){
                if(rating[j] < rating[i]) l++;
            }

            for(int j=i+1;j<rating.Length;j++){
                if(rating[i] < rating[j]) r++;
            }

            ans += ( l * r) + (i - l) * (rating.Length - i - 1 - r);
        }

        return ans;
    }
}