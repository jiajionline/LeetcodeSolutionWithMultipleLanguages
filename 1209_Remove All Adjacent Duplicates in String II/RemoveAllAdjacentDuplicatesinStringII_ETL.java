class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            sb.append(c);
            if(sb.length() >= k){
                boolean allSame = true;
                for(int i=1;i<k;i++) {
                    if(sb.charAt(sb.length()-i) != sb.charAt(sb.length()-(i+1))) {
                        allSame= false;
                        break;
                    }
                }
                
                if(allSame) {
                    for(int i=1;i<=k;i++) sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        
        return sb.toString();
    }
}