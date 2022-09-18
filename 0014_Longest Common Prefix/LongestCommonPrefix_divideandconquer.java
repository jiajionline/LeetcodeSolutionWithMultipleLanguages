class Solution {
    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefix(0, strs.length - 1, strs);
    }
    
    private String longestCommonPrefix(int l , int r, String[] strs) {
        if(l == r) return strs[l];
        if(l + 1 == r) return longestCommonPrefix(strs[l], strs[r]);
        int mid = (r-l)/2 + l;
        String s1 = longestCommonPrefix(l, mid, strs);
        String s2 = longestCommonPrefix(mid+1, r, strs);
        return longestCommonPrefix(s1, s2);
    }
    
    private String longestCommonPrefix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Math.min(s1.length(), s2.length()); i++) {
            if(s1.charAt(i) == s2.charAt(i))
                sb.append(s1.charAt(i));
            else
                break;
        }
        
        return sb.toString();
    }
}