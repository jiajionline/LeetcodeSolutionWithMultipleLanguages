class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += v(s.charAt(i));
            if (i > 0 && v(s.charAt(i)) > v(s.charAt(i - 1)))
                ans -= 2 * v(s.charAt(i - 1));
        }
        return ans;
    }

    private int v(char R) {
        switch (R) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                break;
        }
        return 0;
    }
}