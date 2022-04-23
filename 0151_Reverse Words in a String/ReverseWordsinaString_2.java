class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] splits = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=splits.length - 1; i>=0;i--) {
            sb.append(splits[i]);
            sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}