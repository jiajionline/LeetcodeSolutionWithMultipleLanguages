class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int index = 0;
        
        while(index < s.length()) {
            char c = s.charAt(index);
            if(Character.isDigit(c)) {
                count *= 10;
                count += (c - '0');
            }else if(c == '[') {
                strStack.push(sb);
                countStack.push(count);
                count = 0;
                sb = new StringBuilder();
            }else if(c == ']') {
                StringBuilder tmpSb = strStack.pop();
                for(int i=countStack.pop() - 1;i>=0;i--) {
                    tmpSb.append(sb);
                }
                sb = tmpSb;
            }else {
                sb.append(c);
            }
            
            index++;
        }
        
        return sb.toString();
    }
}