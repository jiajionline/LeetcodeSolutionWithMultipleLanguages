public class Solution {

    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return;
        }

        boolean setFirstRowToZeroes = false;
        boolean setFirstColumnToZeroes = false;

        //check if first column needs to be set to zero
        for(int row=0;row<matrix.length;row++){
            if(matrix[row][0] == 0){
                setFirstColumnToZeroes=true;
                break;
            }
        }

        //check if first row needs to be set to zero
        for(int col=0;col<matrix[0].length;col++){
            if(matrix[0][col] == 0){
                setFirstRowToZeroes=true;
                break;
            }
        }

        //mark columns and rows to be set to zero
        for(int row=1;row<matrix.length;row++){
            for(int col=1;col<matrix[0].length;col++){
                if(matrix[row][col]==0){
                    matrix[row][0]=0;
                    matrix[0][col]=0;
                }
            }
        }

        // make rows zero
        for(int row=1;row<matrix.length;row++){
            if(matrix[row][0]==0){
                for(int col=1;col<matrix[0].length;col++){
                    matrix[row][col]=0;
                }
            }
        }

        // make columns zero
        for(int col=1;col<matrix[0].length;col++){
            if(matrix[0][col]==0){
                for(int row=1;row<matrix.length;row++){
                    matrix[row][col]=0;
                }
            }
        }

        // zero out first row (if needed)
        if(setFirstRowToZeroes){
            for(int col=0;col<matrix[0].length;col++){
                matrix[0][col]=0;
            }
        }

        // zero out first column (if needed)
        if(setFirstColumnToZeroes){
            for(int row=0;row<matrix.length;row++){
                matrix[row][0]=0;
            }
        }

    }
}