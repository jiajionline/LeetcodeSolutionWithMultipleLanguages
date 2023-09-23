class Solution {
    public String mergeAlternately(String word1, String word2) {
        if(word1 == null) return word2;
        if(word2 == null) return word1;

        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 0, w1Len = word1.length(), w2Len = word2.length();
        boolean isW1 = true;
        while(p1 < w1Len && p2 < w2Len) {
            if(isW1) {
                sb.append(word1.charAt(p1++));
            }else{
                sb.append(word2.charAt(p2++));
            }
            isW1 = !isW1;
        }

        while(p1 < w1Len) sb.append(word1.charAt(p1++));
        while(p2 < w2Len) sb.append(word2.charAt(p2++));
        return sb.toString(); 
    }
}