class Solution {
    public int calculate(String s) {
        Queue<Character> q = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if (c != ' ') q.offer(c);
        }
        
        q.offer(' ');
        return helper(q);
    }
    
    private int helper(Queue<Character> q) {
        int num = 0, prev = 0, sum = 0;
        char prevOp = '+';
        
        while(!q.isEmpty()){
            char c = q.poll();
            if(Character.isDigit(c)) {
                num *= 10;
                num += (c - '0');
            }else if(c == '(') {
                num = helper(q);
            }else {
                switch(prevOp) {
                    case '+':
                        sum += prev;
                        prev = num;
                        break;
                    case '-':
                        sum += prev;
                        prev = -num;
                        break;
                    case '*':
                        prev *= num;
                        break;
                    case '/':
                        prev /= num;
                        break;
                }
                
                if(c == ')') break;
                prevOp = c;
                num = 0;
            }
        }
        
        return sum + prev;
    }
}