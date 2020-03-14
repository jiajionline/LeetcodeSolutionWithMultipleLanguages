class Solution {
    public char FindTheDifference (string s, string t) {
        if (s == null && t != null && t.Length == 1) {
            return t[0];
        }

        int a = 0;
        int b = 0;
        foreach (var c in s) {
            a ^= (int) c;
        }

        foreach (var c in t) {
            b ^= (int) c;
        }

        a ^= b;

        return (char) a;
    }
}