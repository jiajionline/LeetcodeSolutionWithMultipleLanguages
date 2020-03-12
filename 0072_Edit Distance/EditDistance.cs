public class Solution{
    public int MinDistance(string word1, string word2){
        int[,] DP = new int[word1.Length + 1, word2.Length + 1];
        for(int i = 0; i <= word1.Length; i++){
            DP[i, 0] = i;
        }

        for(int j = 0; j <= word2.Length; j++){
            DP[0, j] = j;
        }

        for(int i = 1; i <= word1.Length; i++){
            for(int j = 1; j <= word2.Length; j++){
                if(word1[i - 1] == word2[j - 1]){
                    DP[i, j] = DP[i - 1, j - 1];
                } else{
                    DP[i, j] = 1 + Math.Min(DP[i - 1, j - 1], Math.Min(DP[i - 1, j], DP[i, j - 1]));
                }
            }
        }

        return DP[word1.Length, word2.Length];
    }
}