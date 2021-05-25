public class Solution {
    public int[][] FloodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || sr < 0 || sc < 0 || sr >= image.Length || sc >= image[0].Length || image[sr][sc] == newColor) return image;
        
        FloodFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void FloodFill(int[][] image, int sr, int sc, int oldColor, int newColor)
    {
        if(sr < 0 || sc < 0 || sr >= image.Length || sc >= image[0].Length || image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;
        FloodFill(image, sr-1, sc, oldColor, newColor);
        FloodFill(image, sr+1, sc, oldColor, newColor);
        FloodFill(image, sr, sc-1, oldColor, newColor);
        FloodFill(image, sr, sc+1, oldColor, newColor);
    }
}