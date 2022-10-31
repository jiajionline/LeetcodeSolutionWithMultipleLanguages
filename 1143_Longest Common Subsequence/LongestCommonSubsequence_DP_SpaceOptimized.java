/**
 * Tabulation uses a table to keep track of subproblem results and works in a bottom-up manner: 
 * solving the smallest subproblems before the large ones, in an iterative manner. Often, people use the words "tabulation" and "dynamic programming" interchangeably.
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() > text2.length()) {
            String tmp = text1;
            text1 = text2;
            text2 = tmp;
        }
        
        int m = text1.length();
        int n = text2.length();
        
        int[] previous = new int[m + 1];
        int[] current = new int[m + 1];
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++)
            {
                if(text1.charAt(j-1) == text2.charAt(i-1))
                    current[j] = previous[j-1] + 1;
                else
                    current[j] = Math.max(previous[j], current[j-1]);    
            }
            
            int[] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[m];
    }
}