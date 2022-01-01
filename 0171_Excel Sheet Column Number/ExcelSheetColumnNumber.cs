public class Solution {
    public int TitleToNumber(string columnTitle) {
        var ans = 0;
        if(string.IsNullOrEmpty(columnTitle)) return ans;
        
        for(int i=0;i< columnTitle.Length;i++)
        {
            ans *= 26;
            ans += (columnTitle[i] - 'A' + 1);
        }
        
        return ans;
    }
}