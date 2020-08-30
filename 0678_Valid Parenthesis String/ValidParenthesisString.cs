public class Solution {
    private const int VALID = 2;
    private const int NOT_VALID = 1; 
    //top-down
    public bool CheckValidString(string s) {
        if (string.IsNullOrEmpty(s)) return true;
        var len = s.Length;
        var DP = new int[len,len];
        IsValid(s, DP, 0, len-1);
        return DP[0,len-1] == VALID;
    }

    private bool IsValid(string s, int[,] DP, int i, int j){
        if(i > j) return true;
        if(DP[i,j] > 0){
            var valid = DP[i,j] == VALID ? true : false;
            return valid;
        }

        if(i == j){
            DP[i,j] = s[i] == '*' ? VALID : NOT_VALID;
            var valid = DP[i,j] == VALID ? true : false;
            return valid;
        }

        if((s[i] == '(' || s[i] == '*') && (s[j] == ')' || s[j] == '*') && IsValid(s, DP, i+1,j-1)){
            DP[i,j] = VALID;
            return true;
        }

        for(int p = i;p<j;p++){
            if(IsValid(s,DP,i,p) && IsValid(s,DP,p+1,j)){
                DP[i,j] = VALID;
                return true;
            }
        }

        DP[i,j] = NOT_VALID;
        return false;
    }
}