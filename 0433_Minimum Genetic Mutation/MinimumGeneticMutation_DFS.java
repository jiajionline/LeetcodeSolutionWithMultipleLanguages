class Solution {
    private int ans = Integer.MAX_VALUE;
    
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        char[] GENES = new char[]{'A','C','G','T'};
        Set<String> banks = new HashSet<String>();
        for(String b : bank)  banks.add(b);
        banks.add(start);
        
        Set<String> visited = new HashSet();
        DFS(banks, visited, start, 0, GENES, end);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private void DFS(Set<String> banks, Set<String> visited, String g, int mutations, char[] GENES, String end) {
        if(!banks.contains(g) || visited.contains(g)) return;
        if(g.equals(end)) {
            ans = Math.min(mutations, ans);
            return;
        }
        
        visited.add(g);
        
        char[] chars = g.toCharArray();
        
        for(int i=0;i<chars.length;i++) {
            for(int j=0; j < GENES.length; j++) {
                char oldChar = chars[i];
                chars[i] = GENES[j];
                String newGene = new String(chars);
                DFS(banks, visited, newGene, mutations+1, GENES, end);
                chars[i] = oldChar;
            }
        }
    }
}