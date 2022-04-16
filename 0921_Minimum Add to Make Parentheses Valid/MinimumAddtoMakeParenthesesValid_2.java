class Solution {
    public int minAddToMakeValid(String s) {
        int bal = 0;
        int ans = 0;
        for(char c : s.toCharArray()) {
            bal += (c == '(' ? 1 : -1);
            if(bal == -1) {
                bal = 0;
                ans++;
            }
        }
        
        return ans + bal;
    }
}