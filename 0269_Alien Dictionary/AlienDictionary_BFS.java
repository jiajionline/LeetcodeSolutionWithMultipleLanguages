class Solution {
    public String alienOrder(String[] words) {
        
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new ArrayList<>());
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
                    indegree.put(word2.charAt(j), indegree.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        
        // Topological kahn bfs
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        // find all root node (the nodes doesn't have other nodes point to, these node should come first)
        for (Character c : indegree.keySet()) {
            if (indegree.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            for (Character next : graph.get(c)) {
                // remove the parent
                indegree.put(next, indegree.get(next) - 1);
                // if no parent, just remove from indegree and put into queue for next iteration
                if (indegree.get(next).equals(0)) 
                    queue.add(next);
            }
        }
        
        if (sb.length() < indegree.size()) {
            return "";
        }
        return sb.toString();
    }
}