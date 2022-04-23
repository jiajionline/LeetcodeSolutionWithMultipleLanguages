class Solution {
    public boolean checkValidString(String s) {
        return DFS(s.toCharArray(), 0);
    }
    
    private boolean DFS(char[] chars, int index) {
        if(index == chars.length) {
            if(isValid(chars)) return true;
            return false;
        }
        
        char c = chars[index];

        if(c == '*') {
            for(char ch : "() ".toCharArray()) {
                chars[index] = ch;
                if(DFS(chars, index+1)) return true;
            }

            chars[index] = '*';
        }else {
            if(DFS(chars, index+1)) return true;
        }
        
        return false;
    }
    
    private boolean isValid(char[] chars) {
        int bal = 0;
        for(char c : chars) {
            if(c == '(') {
                bal++;
            }else if(c == ')') {
                if(bal == 0) return false;
                bal--;
            }
        }
        
        return bal == 0;
    }
}