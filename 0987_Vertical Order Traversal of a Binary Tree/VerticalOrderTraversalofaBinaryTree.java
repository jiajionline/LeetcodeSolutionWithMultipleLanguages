class Point{
    int col,row,val;
    Point(int col,int row,int val){
        this.col = col;
        this.row = row;
        this.val = val;
    }
}
public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>(){
            public int compare(Point p1,Point p2){
                if(p1.col < p2.col) return -1;
                if(p2.col < p1.col) return 1;
                if(p1.row < p2.row) return -1;
                if(p1.row > p2.row) return 1;
                return Integer.compare(p1.val, p2.val);
            }
        });
        
        // start from Root col = 0, row = 0 and fill in pq
        verticalTraversalHelper(root,0,0,pq);
        Point prev = null;        
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            Point p = pq.poll();
            //merge the val for the same col
            if(prev != null && p.col != prev.col){
                ans.add(new ArrayList<Integer>(list));
                list.clear();
            }
            list.add(p.val);
          prev = p;
        }
        
        ans.add(list);
        return ans;
    }
    
    private void verticalTraversalHelper(TreeNode root,int col,int row,PriorityQueue<Point> pq){
        if(root == null) return;
        pq.offer(new Point(col,row,root.val));
        verticalTraversalHelper(root.left,col-1,row+1,pq);
        verticalTraversalHelper(root.right,col+1,row+1,pq);
    }
}