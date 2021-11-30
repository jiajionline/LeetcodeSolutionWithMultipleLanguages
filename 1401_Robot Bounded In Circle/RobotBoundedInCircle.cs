public class Solution {
    public bool IsRobotBounded(string instructions) {
        var x = 0;
        var y = 0;
        var d = 1;
        var dx = new int[]{-1,0,1,0};
        var dy = new int[]{ 0,1,0,-1};
        
        foreach(var c in instructions)
        {
            if(c == 'G')
            {
                x += dx[d];
                y += dy[d];
            }else{
                d = (d + (c == 'L' ? 3 : 1)) % 4;
            }
        }
        
        return (x == 0 && y == 0) || d != 1;
    }
}