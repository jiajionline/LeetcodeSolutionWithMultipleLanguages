//Recursion + Memoization to avoid duplicate computation
public class Solution {
    private Dictionary<string,int> dict = new Dictionary<string,int>();
    public int NumDecodings(string s) {
        dict.Add("",1);
        return Ways(s);
    }

    private int Ways(string s){
        if(dict.ContainsKey(s)) return dict[s];
        if(s[0] == '0') return 0;
        if(s.Length == 1) return 1;

        var ans = Ways(s.Substring(1));
        var twoDigital = Convert.ToInt32(s.Substring(0,2));
        if(twoDigital <= 26 && twoDigital >= 10){
            ans += Ways(s.Substring(2));
        } 

        dict.Add(s,ans);

        return ans;

    }
}