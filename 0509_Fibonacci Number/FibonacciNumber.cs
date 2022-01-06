public class Solution {
    public int Fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int prev = 0;
        int curr = 1;
        for(int i=2;i<=n;i++)
        {
            var next = curr + prev;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
}