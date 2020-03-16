public class Solution {
   public int UniquePaths(int m, int n) {
       var DP = new int[m,n];
       for(int i=0;i<DP.GetLength(0);i++){
           for(int j=0;j<DP.GetLength(1);j++){
               if(i==0 || j==0){
                   DP[i,j] = 1;
               }
               else{
                   DP[i,j] = DP[i-1,j] + DP[i,j-1];
               }       
           }
       }
       return DP[m-1,n-1];
   }
}