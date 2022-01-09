public class Solution {
    public bool IsRobotBounded(string instructions) {
        var x = 0;
        var y = 0;
        
        //0,1,2,3 means west,north,east, south
        var d = 1;
        //west,north,east, south
        var dx = new int[]{-1,0,1,0};
        var dy = new int[]{ 0,1,0,-1};
        
        foreach(var ch in instructions)
        {
            if(ch == 'G')
            {
                x += dx[d];
                y += dy[d];
            }else {
                d = (ch == 'L' ? d + 3 : d+1) % 4;
            }
        }
        
        return (x == 0 && y == 0) || (d!= 1);
    }
}