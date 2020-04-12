class Solution {
    public int strStr(String s, String t) {
        if (t.isEmpty()) return 0; // edge case
        int n = s.length();
        int m = t.length();
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m && s.charAt(i + j) == t.charAt(j); j++)
                if (j == m - 1) return i;
        }
        return -1;
    }
}