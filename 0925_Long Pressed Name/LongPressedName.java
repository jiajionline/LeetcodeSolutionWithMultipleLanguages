class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        int p = 0, m = name.length(), n = typed.length();
        for (int q = 0; q < n; q++)
            if (p < m && name.charAt(p) == typed.charAt(q))
                ++p;
            else if (q == 0 || typed.charAt(q) != typed.charAt(q - 1))
                return false;
        return p == m;
    }
}