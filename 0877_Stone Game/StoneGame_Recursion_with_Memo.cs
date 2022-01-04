public class Solution {
    public bool StoneGame(int[] piles) {
        var n = piles.Length;
        var memo = new int[n][];
        for(var i=0;i<n;i++)
        {
            memo[i] = new int[n];
            Array.Fill(memo[i], int.MinValue);
        }
        
        return GetScore(piles, 0, n-1, memo) >= 0;
    }
    
    private int GetScore(int[] piles, int l , int r, int[][] memo)
    {
        if(l == r) return piles[l];
        if(memo[l][r] > int.MinValue) return memo[l][r];
        var score = Math.Max(piles[l] - GetScore(piles, l+1, r, memo), piles[r] - GetScore(piles,l, r-1, memo));
        memo[l][r] = score;
        return score;
    }
}