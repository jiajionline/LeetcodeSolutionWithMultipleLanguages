public class Solution {
    public int Tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        var a = 0;
        var b = 1;
        var c = 1;
        
        for(int i= 3;i<=n;i++){
            var d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        
        return c;
    }
}