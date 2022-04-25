class Solution {
    private static final char[] GeneChars = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        
        Set<String> bankSet = new HashSet<>();
        for(String gene : bank) bankSet.add(gene);
        bankSet.add(start);
        if(!bankSet.contains(end)) return -1;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        
        int ans = 0;
        
        while(queue.size() > 0) {
            int size = queue.size();
            ans++;
            
            while(size-- > 0) {
                char[] genes = queue.poll().toCharArray();
                
                for(int i=0;i< genes.length;i++) {
                    char original = genes[i];
                    for(int j=0;j<GeneChars.length;j++) {
                        if(GeneChars[j] == original) continue;
                        genes[i] = GeneChars[j];
                        String newGene = new String(genes);
                        if(visited.contains(newGene) || !bankSet.contains(newGene)) continue;
                        if(newGene.equals(end)) return ans;
                        queue.add(newGene);
                        visited.add(newGene);
                    }
                    
                    genes[i] = original;
                }
            }
        }
        
        return -1;
    }
}