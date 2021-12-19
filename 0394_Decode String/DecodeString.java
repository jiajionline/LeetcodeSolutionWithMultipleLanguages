class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        char[] s_arr = s.toCharArray();
        
        Stack<Integer> countStack = new Stack();
        Stack<String> strStack = new Stack();
        StringBuffer buffer = new StringBuffer();
        int index = 0;
        
        while(index < s_arr.length)
        {
            if(Character.isDigit(s_arr[index]))
            {
                int count = 0;
                while(Character.isDigit(s_arr[index])){
                    count = count * 10 + Integer.valueOf(s_arr[index++]-'0');   
                }
                countStack.push(count);
                
            }else if(s_arr[index] == '['){
                strStack.push(buffer.toString());
                buffer.setLength(0);
                index++;
            }else if(s_arr[index] == ']'){
                StringBuffer tmp = new StringBuffer();
                int count = countStack.pop();
                tmp.append(strStack.pop());
                for(int i=0;i<count;i++)
                {
                    tmp.append(buffer.toString());
                }
                buffer.setLength(0);
                buffer.append(tmp.toString());
                index++;
            }else{
                buffer.append(s_arr[index++]);
            }
        }
        
        return buffer.toString();
        
    }
}