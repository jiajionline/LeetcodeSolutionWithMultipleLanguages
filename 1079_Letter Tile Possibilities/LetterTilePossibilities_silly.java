class Solution {
    private Set<String> set = new HashSet<String>();
    public int numTilePossibilities(String tiles) {
        
        for(int len=1; len<=tiles.length();len++) {
            permutate(tiles,  new ArrayList<Character>(), len, new boolean[tiles.length()]);    
        }
        
        return set.size();
    }
    
    private void permutate(String tiles , List<Character> list, int len, boolean[] visited) {
        if(list.size() == len) {
            StringBuilder sb = new StringBuilder();
            for(char c : list) sb.append(c);
            set.add(sb.toString());
            return;
        }
        
        for(int i=0;i<tiles.length();i++) {
            if(visited[i]) continue;
            visited[i] = true;
            list.add(tiles.charAt(i));
            permutate(tiles, list, len, visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}