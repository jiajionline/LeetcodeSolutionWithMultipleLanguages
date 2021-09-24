public class Solution {
    public int MinFlipsMonoIncr(string s) {
        var dpZero = new int[s.Length];
        var dpOne = new int[s.Length];
        
        for(int i=0;i<s.Length;i++)
        {
            if(i == 0){
                if(s[i] == '1') dpZero[i] = 1;
            }else if(s[i] == '1')
            {
                dpZero[i] = dpZero[i-1] + 1;
            }else{
                dpZero[i] = dpZero[i-1];
            }
        }
        
        for(int i=s.Length-1;i>=0;i--)
        {
            if(i == s.Length - 1){
                if(s[i] == '0') dpOne[i] = 1;
            }else if(s[i] == '0'){
                dpOne[i] = dpOne[i+1] + 1;
            }else{
                dpOne[i] = dpOne[i+1];
            }
        }
        
        var ans = s.Length * 2;
        
        for(int i=1;i<s.Length;i++)
        {
            ans = Math.Min(dpZero[i-1] + dpOne[i], ans);
        }
        
        ans = Math.Min(ans, Math.Min(dpZero[s.Length-1], dpOne[0]));
        
        return ans;
    }
}