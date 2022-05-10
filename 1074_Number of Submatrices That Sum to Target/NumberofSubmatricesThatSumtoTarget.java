class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length + 1;
        int[][] sum = new int[m][n];
        
        for (int i = 0; i < m; i++){
            for (int j = 1; j < n; j++){
                sum[i][j] = sum[i][j - 1] + matrix[i][j - 1];
            }
        }
        
        
        for (int start = 0; start < n; start++){
            for (int end = start + 1; end < n; end++ ){
                
                int sumOfSubMatrix = 0;
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(0, 1);
                for(int l = 0; l < m; l++){
                    sumOfSubMatrix += sum[l][end] - sum[l][start];
                    if (map.containsKey(sumOfSubMatrix - target))
                        count += map.get(sumOfSubMatrix - target);
                    map.put(sumOfSubMatrix, map.getOrDefault(sumOfSubMatrix, 0) + 1);
                    
                }
            }
        }
        
        return count;
        
    }
}