class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || sr<0 || sc<0 || sr >= image.length || sc >= image[0].length) return image;
        if(image[sr][sc] == newColor) return image;
        floodFill(image, sr, sc, image.length, image[sr].length, image[sr][sc], newColor);
        return image;
    }
    
    private void floodFill(int[][] image, int sr, int sc, int rowLen, int colLen, int oldColor, int newColor){
        if(sr<0 || sc<0 || sr>=rowLen || sc>=colLen || image[sr][sc]!=oldColor) return;
        image[sr][sc] = newColor;
        floodFill(image,sr-1,sc,rowLen, colLen,oldColor, newColor);
        floodFill(image,sr,sc-1,rowLen, colLen,oldColor, newColor);
        floodFill(image,sr+1,sc,rowLen, colLen,oldColor, newColor);
        floodFill(image,sr,sc+1,rowLen, colLen,oldColor, newColor);
    }
}