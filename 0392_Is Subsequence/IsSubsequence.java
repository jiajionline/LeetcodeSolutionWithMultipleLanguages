class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for(char c : t.toCharArray()) {
            if(i == s.length()) break;
            if(s.charAt(i) == c) i++;
        }

        return i == s.length();
    }
}