public class Solution {
    public bool JudgeCircle (string moves) {
        var x = 0;
        var y = 0;
        foreach (var c in moves) {
            switch (c) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }

        return x == 0 && y == 0;
    }
}