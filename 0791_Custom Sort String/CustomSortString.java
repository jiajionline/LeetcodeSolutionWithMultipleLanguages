class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c - 'a']++;
        
        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()) {
            for(int i=0;i<count[c-'a'];i++) sb.append(c);
            count[c-'a'] = 0;
        }
        
        for(int i=0;i<count.length;i++) {
            for(int j=0;j<count[i];j++)
                sb.append((char)('a' + i));
        }
        
        return sb.toString();
    }
}