public class Solution {
    public int UniquePathsWithObstacles(int[][] obstacleGrid) {
        var dp = new int[obstacleGrid.Length, obstacleGrid[0].Length];
        
        for(int i=0;i< obstacleGrid.Length;i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }else{
                dp[i,0] = 1;
            }
        }
        
        for(int j=0;j < obstacleGrid[0].Length; j++){
            if(obstacleGrid[0][j] == 1){
                break;
            }else{
                dp[0,j] = 1;
            }
        }
        
        for(int i=1;i<obstacleGrid.Length;i++){
            for(int j=1;j<obstacleGrid[0].Length;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i,j] = 0;
                }else{
                    dp[i,j] = dp[i-1,j] + dp[i,j-1];
                }
            }
        }
        
        return dp[obstacleGrid.Length -1, obstacleGrid[0].Length - 1];
    }
}