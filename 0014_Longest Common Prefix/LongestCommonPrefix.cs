public class Solution {
    public string LongestCommonPrefix(string[] strs) {
        if(strs.Length == 1) return strs[0];
    
        for(int i=0;i<strs[0].Length;i++)
        {
            var ch = strs[0][i];
            for (int j = 1; j < strs.Length; j++)
            {
                if (i == strs[j].Length || strs[j][i] != ch)
                    return strs[0].Substring(0, i);
            }
        }
        
        return strs[0];
    }
}