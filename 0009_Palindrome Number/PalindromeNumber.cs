class Solution {
    public bool IsPalindrome (int x) {
        if (x == int.MinValue) return false;

        long y = Math.Abs (x);
        long value = 0;

        while (y > 0) {
            value *= 10;
            value += (y % 10);
            y /= 10;
        }

        if (value > int.MaxValue) return false;

        return x == (int) value ? true : false;
    }
}