class Solution {
    private int i = 0;
    
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while(i < s.length()) {
            char c = s.charAt(i++);
            if(Character.isDigit(c)){
                n *= 10;
                n += ( c- '0');
            }else if(Character.isLetter(c)){
                sb.append(c);
            }else if(c == '['){
                String subS = decodeString(s);
                for(int j=0;j<n;j++){
                    sb.append(subS);
                }
                n = 0;
            }else{
                break;
            }
        }
        
        return sb.toString();
    }
}