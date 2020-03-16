public class Solution {
   public int UniquePathsWithObstacles(int[][] obstacleGrid) {
       var m = obstacleGrid.Length+1;
       var n = obstacleGrid[0].Length+1;

       var DP = new int[m,n];
      
       for(int i=1;i<m;i++){
           for(int j=1;j<n;j++){
              if(obstacleGrid[i-1][j-1] == 1){
                  DP[i,j] = 0;
              }else if(i==1 && j==1){
                  DP[i,j] = 1;
              }else{
                  DP[i,j] = DP[i-1,j] + DP[i,j-1];
              }
           }
       }

       return DP[m-1,n-1];               
   }
}
