public class Solution {
   public string LongestPalindrome(string s) {
       if(string.IsNullOrEmpty(s)) return "";
       bool[,] DP = new bool[s.Length, s.Length];
       var max = 0;
       var ret = string.Empty;

       for(int i=s.Length-1;i>=0;i--)
       {
           for(int j=i;j<s.Length;j++)
           {
    // 当两个字符相等时，有两种情况。1 j-i<=2 like a,aa,aba
    // 2 当前的j和i 各自前面的子串是Palindromic                               
               if(s[i] == s[j] && (j-i <= 2 || DP[i+1,j-1]))
               {
                   DP[i,j] = true;
                   if(j-i+1>max)
                   {
                       max = j-i+1;
                       ret = s.Substring(i, j-i + 1);                       
                   }
               }               
           }
       }

       return ret;
   }
}
