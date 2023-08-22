class NumMatrix {
    private int[][] _matrix;

    public NumMatrix(int[][] matrix) {
        _matrix = matrix;
        int m = matrix.length, n = matrix[0].length;
        for(int i=1;i<m;i++) _matrix[i][0] += _matrix[i-1][0];
        for(int i=1;i<n;i++) _matrix[0][i] += _matrix[0][i-1];
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                _matrix[i][j] = _matrix[i][j] + _matrix[i-1][j] + _matrix[i][j-1] - _matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int v = _matrix[row2][col2];
        if(row1-1 >= 0) v -= _matrix[row1-1][col2];
        if(col1-1 >= 0) v -= _matrix[row2][col1-1];
        if(row1-1 >=0 && col1-1>=0) v += _matrix[row1-1][col1-1];
        return v;
    }
}