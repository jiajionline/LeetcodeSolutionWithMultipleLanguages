class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        char[] genes = new char[]{'A','C','G','T'};
        Set<String> banks = new HashSet<String>();
        for(String b : bank)  banks.add(b);
        
        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.add(start);
        int ans = 0;
        
        while(queue.size() > 0) {
            int count = queue.size();
            
            while(count-- > 0) {
                String g = queue.poll();
                if(g.equals(end)) return ans;
                
                visited.add(g);
                char[] char_gene = g.toCharArray();
                
                for(int i=0;i<char_gene.length;i++) {
                    char old_char = char_gene[i];
                    for(int j=0;j<genes.length;j++) {
                        char_gene[i] = genes[j];
                        String newGene = new String(char_gene);
                        if(!visited.contains(newGene) && banks.contains(newGene))
                            queue.add(newGene);
                    }
                    char_gene[i] = old_char;
                }
            }
            
            ans++;
        }
        
        return -1;
    }
}