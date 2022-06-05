class Solution {
    private Map<Character, List<Character>> graph;
    private Map<Character, Integer> visited;
    private boolean isValid = true;
    private StringBuilder sb = new StringBuilder();
    public String alienOrder(String[] words) {
        graph = new HashMap<>();
        visited = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                visited.putIfAbsent(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1. like  abc , ab is invalid
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
        
        // Topological dfs
        for(Character c : graph.keySet()) {
            if(visited.get(c) == 0) dfs(c);
        }
        
        return (!isValid || sb.length() < graph.size()) ? "" : sb.reverse().toString();
    }

    private void dfs(char c) {
        visited.put(c, 1);
        for(Character next : graph.get(c)) {
            if(visited.get(next) == 0) dfs(next);
            else if(visited.get(next) == 1) isValid = false;
        }
        sb.append(c);
        visited.put(c, 2);
    }
}