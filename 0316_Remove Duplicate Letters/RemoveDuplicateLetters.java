class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashSet<Character> seen = new HashSet<Character>();
        int[] occurrences = new int[128];
        int n = s.length();
        
        for(int i=0; i<n;i++)
            occurrences[s.charAt(i)] = i;
        
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(!seen.contains(ch)) {
                while(stack.size() > 0 && stack.peek() > ch && occurrences[stack.peek()] > i)
                    seen.remove(stack.pop());
                
                seen.add(ch);
                stack.push(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0) sb.insert(0, stack.pop());
        
        return sb.toString();
    }
}