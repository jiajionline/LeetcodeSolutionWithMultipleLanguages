public class Solution {
    public int ShortestBridge(int[][] A) {
        var q = new Queue<Tuple<int,int>>();
        var found = false;
        for(int i=0;i<A.Length && !found;i++){
            for(int j=0;j<A[i].Length && !found;j++){
                if(A[i][j] == 1){
                    DFS(A,i,j,q);
                    found = true;
                }
            }
        }

        int steps = 0;
        var dirs = new List<int>{0,1,0,-1,0};
        while(q.Count > 0){
            var c = q.Count;
            while(c-- > 0){
                var item = q.Dequeue();
                var x = item.Item1;
                var y = item.Item2;

                for(int i=0;i<4;i++){
                    int tx = x + dirs[i];
                    int ty = y + dirs[i+1];
                    if (tx < 0 || ty < 0 || tx >= A.Length || ty >= A[0].Length || A[tx][ty] == 2) continue;          
                    if (A[tx][ty] == 1) return steps;
                    A[tx][ty] = 2;
                    q.Enqueue(new Tuple<int, int>(tx, ty));

                }
            }
            steps++;
        }

        return -1;
    }

    private void DFS(int[][] A, int x, int y, Queue<Tuple<int,int>> q){
        if (x < 0 || y < 0 || x >= A.Length || y >= A[0].Length || A[x][y] != 1) return;
        A[x][y] = 2;
        q.Enqueue(new Tuple<int,int>(x,y));
        DFS(A,x-1,y,q);
        DFS(A,x,y-1,q);
        DFS(A,x+1,y,q);
        DFS(A,x,y+1,q);
    }
}