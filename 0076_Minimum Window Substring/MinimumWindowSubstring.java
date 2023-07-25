class Solution {
    public String minWindow(String s, String t) {
        int[] charS = new int[128];
        int[] charT = new int[128];
        for(char c : t.toCharArray()) charT[c]++;
        int l = 0, len = Integer.MAX_VALUE, start = 0;
        for(int r = 0;r<s.length();r++) {
            charS[s.charAt(r)]++;
            while(include(charS, charT)) {
                if(r-l+1 < len) {
                    start = l;
                    len = r-l+1;
                }
                charS[s.charAt(l++)]--;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    private boolean include(int[] charS, int[] charT) {
        for(int i=0;i<charS.length;i++) {
            if(charS[i] < charT[i]) return false;
        }
        return true;
    }
}