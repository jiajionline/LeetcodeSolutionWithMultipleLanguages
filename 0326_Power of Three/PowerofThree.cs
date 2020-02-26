public class Solution {
    public bool IsPowerOfThree(int n) {
        if(n==0) return false;
        return n == Math.Pow(3,Math.Round(Math.Log(n)/Math.Log(3)));
    }
}