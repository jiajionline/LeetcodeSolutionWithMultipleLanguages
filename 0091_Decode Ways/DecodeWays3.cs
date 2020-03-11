//Recursion (Brute Force)
public class Solution {
    public int NumDecodings(string s) {
        return Ways(s);
    }

    private int Ways(string s){
        if(s.Length == 0) return 1;
        if(s[0] == '0') return 0;
        if(s.Length == 1) return 1;

        var ans = Ways(s.Substring(1));
        var twoDigital = Convert.ToInt32(s.Substring(0,2));
        if(twoDigital <= 26){
            ans += Ways(s.Substring(2));
        } 

        return ans;

    }
}