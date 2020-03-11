//DP
public class Solution {
    public int NumDecodings(string s) {
        if(s == null || s.Length == 0 || s[0] == '0') return 0;
        if(s.Length == 1) return 1;

        int n = s.Length;
        int w1 = 1;
        int w2 = 1;

        for(int i=1;i<n;i++){
            int w = 0;
            if(!IsValid(s[i]) && !IsValid(s[i-1],s[i])) return 0;
            if(IsValid(s[i])) w = w1;
            if(IsValid(s[i-1],s[i])) w += w2;
            w2 = w1;
            w1 = w;
        }       

        return w1;
    }

    private bool IsValid(char c){
        return c != '0';
    }

    private bool IsValid(char c1, char c2){
        var i = (c1 - '0') * 10 + (c2 - '0');
        return i >= 10 && i <= 26;
    }
}