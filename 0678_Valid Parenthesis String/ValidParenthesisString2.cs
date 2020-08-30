public class Solution {
    private const int VALID = 2;
    private const int NOT_VALID = 1; 
    //Bottom Up
    public bool CheckValidString(string s) {
        if (string.IsNullOrEmpty(s)) return true;
        var len = s.Length;
        var DP = new int[len,len];
        for(int i=0;i<len;i++){
            if(s[i] == '*'){
                DP[i,i] = VALID;
            }
        }

        for(int l=2; l <= len;l++){
            for(int i=0;i<=len-l;i++){
                int j=i + l -1;

                if((s[i] == '(' || s[i] == '*') && (s[j] == ')' || s[j] == '*')){
                    if (l == 2 || DP[i + 1,j - 1] == VALID) {
                            DP[i,j] = VALID;
                            continue;                    
                    }
                }

                for (int k = i; k < j; ++k)
                    if (DP[i,k] == VALID && DP[k + 1,j] == VALID) {
                        DP[i,j] = VALID;
                        break;
                }
            }
        }

        return DP[0,len-1] == VALID;
    }
}