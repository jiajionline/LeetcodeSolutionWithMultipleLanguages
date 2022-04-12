class Solution {
    private int[] parents = new int[26];
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<parents.length;i++) parents[i] = i;
        
        for(String equation : equations) {
            char[] chars = equation.toCharArray();
            if(chars[1] == '='){
                parents[find(chars[0]-'a')] = find(chars[3]-'a');
            }
        }
        
        for(String equation : equations) {
            char[] chars = equation.toCharArray();
            if(chars[1] == '!' && parents[find(chars[0]-'a')] == find(chars[3]-'a')) return false;
        }
        
        return true;
        
    }
    
    private int find(int x) {
        if(x != parents[x]) parents[x] = find(parents[x]);
        return parents[x];
    }
}