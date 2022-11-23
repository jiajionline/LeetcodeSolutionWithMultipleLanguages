class Vector2D {
    private int currRow = 0;
    private int currCol = 0;
    private int[][] _vec;
    
    public Vector2D(int[][] vec) {
        _vec = vec;
    }
    
    public int next() {
        hasNext();
        return _vec[currRow][currCol++];
    }
    
    public boolean hasNext() {
        nextValid();
        return currRow < _vec.length;
    }
    
    private void nextValid(){
        while(currRow < _vec.length && currCol == _vec[currRow].length){
            currRow++;
            currCol = 0;
        }
    }
}