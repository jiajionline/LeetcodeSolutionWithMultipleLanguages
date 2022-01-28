public class Solution {
    public int GetSum(int a, int b) {
        return b == 0 ? a : GetSum(a^b, (a&b) << 1);
    }
}