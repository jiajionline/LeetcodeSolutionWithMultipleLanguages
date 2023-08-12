class SnakeGame {
    private int _width;
    private int _height;
    private ArrayList<int[]> snake;
    private int[][] _food;
    private int _foodIndex;

    public SnakeGame(int width, int height, int[][] food) {
        snake = new ArrayList<>();
        snake.add(new int[]{0,0});
        _food = food;
        _foodIndex = 0;
        _width = width;
        _height = height;
    }
    
    public int move(String direction) {
        int[] head = snake.get(0);
        int x = head[0];
        int y = head[1];
        char dir = direction.charAt(0);
        if(dir == 'U') x = x-1;
        if(dir == 'D') x = x+1;
        if(dir == 'L') y = y-1;
        if(dir == 'R') y = y+1;
        if(x < 0 || y < 0 || x >= _height || y >= _width) return -1;
        int size = snake.size();
        for(int i=0;i<snake.size()-1;i++) {
            int[] arr = snake.get(i);
            if(x == arr[0] && y == arr[1]) return -1;
        }

        // eat the food
        if( _foodIndex < _food.length && _food[_foodIndex][0] == x && _food[_foodIndex][1] == y) {
            _foodIndex++;
            snake.add(0, new int[]{x, y});
        }else{
            snake.add(0, new int[]{x, y});
            snake.remove(snake.size()-1);
        }

        return snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */