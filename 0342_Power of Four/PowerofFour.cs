public class Solution {
    public bool IsPowerOfFour(int num) {
        if(num == 0) return false;
        return num == Math.Pow(4, Math.Round(Math.Log(num)/Math.Log(4)));
    }
}