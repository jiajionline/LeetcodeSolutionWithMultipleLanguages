class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int ans = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') depth++;
            else if(c == ')') depth--;
            ans = Math.max(ans, depth);
        }
        
        return ans;
    }
}